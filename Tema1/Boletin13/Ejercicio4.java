package Tema1.Boletin13;

import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int edad;
        do{
            System.out.println("Introduce una edad [0-100]");
            edad = Integer.parseInt(sc.nextLine());
        }while(edad < 0 || edad > 100);

        if (edad <= 12) {
            System.out.println("Eres un niño");
        } else if (edad <= 17 ) {
            System.out.println("Eres un adolescente");
        } else if (edad <= 29) {
            System.out.println("Eres joven");
        } else {
            System.out.println("Eres adulto");
        }
    }
}
