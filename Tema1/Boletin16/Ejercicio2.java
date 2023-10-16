package Tema1.Boletin16;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int base;
        int exponente;

        do {
            System.out.println("Introduce la base de la potencia");
            base = Integer.parseInt(sc.nextLine());

            System.out.println("Introduce el exponente de la potencia");
            exponente = Integer.parseInt(sc.nextLine());
        }while(base < 0  || exponente < 0);

        //Math.pow para calcular una potencia
        double resultado = Math.pow(base, exponente);

        System.out.println("El resultado es " + resultado);
    }
}
