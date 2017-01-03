/*
 *
 * F14. (3 puncte) Scrieti un program care numara aparitiile unui string
 * intr-un fisier dat. Stringul si specificatorul fisierului sunt dati ca
 * argumente in linia de comanda.
 *
 */

#include <stdio.h>
#include <sys/stat.h>
#include <stdbool.h>
#include<string.h>

bool doesFileExist(const char *filename);

int search_in_File(char *fname, char *str);

int main(int argc, char *argv[]) {
    int find_result;

    if (argc < 3 || argc > 3) {
        printf("Trebuie specificat un argument ce reprezinta calea catre fisier si un argument"
                       " ce reprezinta sirul de caractere ce va fi cautat  ! \n");

        return 0;
    }

    if (!doesFileExist(argv[1])) {
        printf("Trebuie specifica un fisier valid ca prim argument ! \n");

        return 0;
    }

    find_result = search_in_File(argv[1], argv[2]);

    if (find_result == -1) {
        perror("Error");

        return 0;
    }

    if (find_result == 0) {
        printf("Nu a fost gasita nici o aparatie a sirului %s in fisierul %s \n", argv[2], argv[1]);

    } else {
        printf("Au fost gasit %d aparitii a sirului %s in fisierul %s \n", find_result, argv[2], argv[1]);

    }

    return 0;
}

bool doesFileExist(const char *filename) {
    struct stat st;
    int result = stat(filename, &st);

    return result == 0;
}

int search_in_File(char *fname, char *str) {
    FILE *fp;
    int find_result = 0;
    char temp[512];
    char *pch;

    if ((fp = fopen(fname, "r")) == NULL) {
        return -1;
    }

    while (fgets(temp, 512, fp) != NULL) {
        pch = strstr(temp, str);

        while (pch != NULL) {
            find_result++;
            pch = strstr(pch + 1, str);
        }
    }

    if (fp) {
        fclose(fp);
    }

    return find_result;
}