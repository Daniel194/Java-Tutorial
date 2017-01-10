/*
 *
 * F3. (2.5 puncte) Scrieti un program care primeste ca argument in linia de
 * comanda un intreg si afisaza descompunerea sa in factori primi.
 *
 */

#include <stdio.h>
#include <stdlib.h>


void prime_factor(int nr);

int main(int argc, char *argv[]) {
    int nr;
    int error;

    if (argc != 2) {
        fprintf(stderr, "Utilizare : %s numar\n", argv[0]);

        exit(EXIT_FAILURE);
    }

    error = sscanf(argv[1], "%d", &nr);

    if (error != 1) {
        fprintf(stderr, "%s trebuie sa fie un numar pozitiv ! \n", argv[1]);

        exit(EXIT_FAILURE);
    }


    fprintf(stderr, "%d = ", nr);
    prime_factor(nr);

    return 0;
}

void prime_factor(int nr) {
    int i, p;

    i = 2;

    if (nr <= 1) {
        printf(" Numarul nu poate fi descompus in factori primi !\n");
        return;
    }

    while (nr > 1) {

        if (nr % i == 0) {
            p = 0;

            while (nr % i == 0) {
                nr /= i;
                p++;
            }

            if (p == 1) {
                printf("%d", i);
            } else {
                printf("%d ^ %d ", i, p);
            }


            if (nr > 1) {
                printf(" * ");
            }

        }

        i++;
    }

    printf("\n");
}
