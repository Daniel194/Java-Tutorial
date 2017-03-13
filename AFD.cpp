
// testeaza, seteaza, respectiv anuleaza bitul cu nr. i>=0
//   numarand de la adresa de memorie s
#define getbit(s, i) ((s)[(i)/8] & 0x01<<(i)%8)
#define setbit(s, i) ((s)[(i)/8] |= 0x01<<(i)%8)
#define killbit(s, i) ((s)[(i)/8] &= ~(0x01<<(i)%8))


#define MAXNRSTARIAFD 64

class AFD {
    int nrstari;
    // nr. de stari; starea initiala este 0; -1=stare nedefinita
    unsigned char *finala;
    // vector caracteristic al starilor finale;
    // bitul s%8 din octetul finala[s/8] este 1 sau 0
    //   dupa cum s este stare finala sau nu;
    int (*tranzitie)[256];
    // tranzitiile;
    // daca din (s,c) se trece in d, atunci t[s][c]=d;
    // daca tranzitia din (s,c) nu este definita, t[s][c]=-1;
public:
    AFD();

    ~AFD();

    int getnrstari();

    // ret. nr. de stari nrstari;
    int setnrstari(int pns);

    // seteaza nr. de stari cu pns si aloca memorie pt. automat;
    // ret. 1=succes, 0=esec;
    int estefinala(int s);

    // ret. ceva !=0 daca s este stare finala si 0 daca nu este stare finala;
    int setfinala(int s);

    // marcheaza starea s ca fiind finala;
    // ret. 1=succes, 0=esec;
    int gettranzitie(int s, unsigned c);

    // ret. starea in care se trece cu tranzitia din (s,c);
    // daca tranzitia din (s,c) nu este definita, ret. -1;
    int settranzitie(int s, unsigned c, int d);

    // incarca in automat tranzitia (s,c) -> d;
    // ret. 1=succes, 0=esec;
    int recunoaste(char const *cuv, int *f);
    // ret. ceva !=0 daca AFD recunoaste cuvantul cuv
    //   si 0 daca nu-l recunoaste (inclusiv daca se blocheaza);
    // in *f furnizeaza starea in care AFD s-a oprit din procesarea lui cuv
    //   (daca nu l-a procesat pana la capat, e starea in care s-a blocat);
};


AFD::AFD() {
    nrstari = 0;
    finala = NULL;
    tranzitie = NULL;
}

AFD::~AFD() {
    delete finala;
    delete tranzitie;
}

int AFD::getnrstari() { return nrstari; }


int AFD::setnrstari(int pns) {
    int i;
    unsigned c;
    if (pns < 0 || pns > MAXNRSTARIAFD)return 0;
    nrstari = pns;
    delete finala;
    delete tranzitie;
    i = sizeof(unsigned char) * (7 + nrstari) / 8;
    if ((finala = new unsigned char[i]) == NULL)return 0;
    while (i--)finala[i] = 0x00;
    if ((tranzitie = new int[nrstari][256]) == NULL) {
        delete finala;
        return 0;
    }
    for (i = 0; i < nrstari; ++i)
        for (c = 0; c < 256; ++c)
            tranzitie[i][c] = -1;
    return 1;
}

int AFD::estefinala(int s) { return getbit(finala, s) != 0; }

int AFD::setfinala(int s) {
    if (s < 0 || s >= nrstari)return 0;
    setbit(finala, s);
    return 1;
}

int AFD::gettranzitie(int s, unsigned c) { return tranzitie[s][c]; }

int AFD::settranzitie(int s, unsigned c, int d) {
    if (s < 0 || s >= nrstari || d < -1 || d >= nrstari)return 0;
    tranzitie[s][c] = d;
    return 1;
}

int AFD::recunoaste(char const *cuv, int *f) {
    int s = 0;
    while (s != -1 && *cuv != '\0') {
        s = tranzitie[s][*cuv];
        ++cuv;
    }
    if (s == -1)return 0;
    if (f)*f = s;
    return estefinala(s);
}

int citeste(AFD &a) {  // citire interactiva; ret. 1=succes,0=esec
    int ns, s, d;
    unsigned c;
    cout << "Alfabet: setul ASCII axtins\n";
    cout << "Dati numarul de stari: ";
    cin >> ns;
    if (!a.setnrstari(ns))return 0;
    cout << "Starea initiala: 0\n";
    cout << "Dati starile finale (-1 dupa ultima): ";
    cin >> s;
    while (s != -1) {
        if (!a.setfinala(s))return 0;
        cin >> s;
    }
    cout << "Dati tranzitiile (st_sursa, cod_zec_caracter, st_destinatie):\n";
    cout << "  (dupa ultima tranzitie introduceti -1)\n";
    do {
        cin >> s;
        if (s == -1)break;
        cin >> c >> d;
        if (!a.settranzitie(s, c, d))return 0;
    } while (1);
    return 1;
}

void afisaza(AFD &a) {  // afisare;
    int ns;
    int i;
    unsigned int c;
    ns = a.getnrstari();
    cout << "Alfabet: setul ASCII axtins\n";
    cout << "Numarul de stari: " << ns << "\n";
    cout << "Starea initiala: 0\n";
    cout << "Stari finale:";
    for (i = 0; i < ns; ++i)if (a.estefinala(i))cout << " " << i;
    cout << "\n";
    cout << "Tranzitiile:\n";
    for (i = 0; i < ns; ++i) {
        for (c = 0; c < 32; ++c)
            if (a.gettranzitie(i, c) != -1)
                cout << " delta(" << i << ",#" << c << ")=" << a.gettranzitie(i, c) << "\n";
        for (c = 32; c < 128; ++c)
            if (a.gettranzitie(i, c) != -1)
                cout << " delta(" << i << "," << (char) c << ")=" << a.gettranzitie(i, c) << "\n";
        for (c = 128; c < 256; ++c)
            if (a.gettranzitie(i, c) != -1)
                cout << " delta(" << i << ",#" << c << ")=" << a.gettranzitie(i, c) << "\n";
    }
}