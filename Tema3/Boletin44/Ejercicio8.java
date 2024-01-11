package Tema3.Boletin44;

import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una frase");
        String cadena = sc.nextLine();
        sc.close();

        System.out.println(cuentaPalabras(cadena));
    }

    public static int cuentaPalabras(String cadena){
        return cadena.trim().split("\\s+").length;
    }
}
