package Tema1.Boletin13;

import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una letra");
        char letra = sc.nextLine().charAt(0);

        if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
            System.out.println("La vocal " + letra + " es vocal");

            if (letra == 'a'){
                System.out.println("Es la primera vocal");
            } else if (letra == 'e') {
                System.out.println("Es la segunda vocal");
            } else if (letra == 'i') {
                System.out.println("Es la tercera vocal");
            } else if (letra == 'o') {
                System.out.println("Es la cuarta vocal");
            } else if (letra == 'u') {
                System.out.println("Es la quinta vocal");
            }
        }else {
            System.out.println("No es vocal");
        }
    }
}

