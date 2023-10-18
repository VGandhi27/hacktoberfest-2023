#include <stdio.h>
#include <string.h>
#define MAKS 256

int palindrom(char [], char []);

int main()
{
    char teks[MAKS], copy[MAKS];
    printf("masukan kata / kalimat : ");
    gets(teks);
    palindrom(teks, copy);
}

int palindrom(char a[], char b[])
{
    strcpy(b, a);
    strrev(b);

    if(strcmp(a, b) == 0 ){
        printf("%s adalah palindrom", a);
    }else{
        printf("%s bukan  palindrom", a);
    }
}