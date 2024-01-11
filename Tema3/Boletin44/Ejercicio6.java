package Tema3.Boletin44;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una palabra");
        String palabra = sc.nextLine();

        System.out.printf("En la palabra %s hay %d vocales diferentes", palabra, contarvocalesdiferentes2(palabra));

    }

    public static int contarVocalesDiferentes(String palabra) {
        palabra = palabra.toLowerCase();

        int cont = 0;

        boolean a = false;
        boolean e = false;
        boolean i = false;
        boolean o = false;
        boolean u = false;

        for (int j = 0; j < palabra.length(); j++) {
            switch (palabra.charAt(j)) {
                case 'a':
                    a = true;
                    break;
                case 'e':
                    e = true;
                    break;
                case 'i':
                    i = true;
                    break;
                case 'o':
                    o = true;
                    break;
                case 'u':
                    u = true;
                    break;
            }
        }
        if (a) cont++;
        if (e) cont++;
        if (i) cont++;
        if (o) cont++;
        if (u) cont++;

        return cont;
    }

    public static int contarvocalesdiferentes2(String palabra){
        palabra = palabra.toLowerCase();

        int cont = 0;

        char[] vocales ={'a', 'e', 'i', 'o', 'u'};

        for (char v : vocales) {
            if (palabra.contains(v+"")) cont++;
        }
        return cont;
    }
}
