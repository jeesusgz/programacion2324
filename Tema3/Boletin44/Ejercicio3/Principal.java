package Tema3.Boletin44.Ejercicio3;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca una frase");
        String cadena = sc.nextLine();

        if (esPalindromo(cadena)){
            System.out.println("La frase es palíndroma");
        }else {
            System.out.println("La frase no es palíndroma");
        }
    }

    public static boolean esPalindromo(String cadena){
        cadena = cadena.replaceAll("\\s+", "").toLowerCase();
        for (int i = 0; i < cadena.length() / 2; i++) {
            if (cadena.charAt(i) != cadena.charAt(cadena.length() - i - 1)){
                return false;
            }
        }
        return true;
    }
}
