/*
 *
 * F3. (2.5 puncte) Scrieti un program care primeste ca argument in linia de
 * comanda un intreg si afisaza descompunerea sa in factori primi.
 *
 */

#include <stdio.h>
#include <ctype.h>
#include <stdbool.h>

bool legal_int(char *str);

void prime_factor(int nr);

int main(int argc, char *argv[]) {
    int nr;

    if (argc < 2) {
        printf("Trebuie specifica un argument ! \n");

        return 0;
    }

    if (!legal_int(argv[1])) {
        printf("Trebuie sa fie un numar pozitiv ! \n");

        return 0;
    }

    sscanf(argv[1], "%d", &nr);
    printf("%d = ", nr);
    prime_factor(nr);

    return 0;
}

bool legal_int(char *str) {

    while (*str != 0)
        if (!isdigit(*str++)) {
            return false;
        }

    return true;
}

void prime_factor(int nr) {
    int i, p;

    i = 2;

    if (nr <= 1) {
        printf(" Numarul nu poate fi descompus in factori primi ! ");
    }

    while (nr > 1) {

        if (nr % i == 0) {
            p = 0;

            while (nr % i == 0) {
                nr /= i;
                p++;
            }

            printf("%d ^ %d ", i, p);

            if (nr > 1) {
                printf(" * ");
            }

        }

        i++;
    }

    printf("\n");
}