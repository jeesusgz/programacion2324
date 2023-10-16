package Tema1.Boletin16;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num;
        do {
            System.out.println("Introduce un número entero");
            num = Integer.parseInt(sc.nextLine());
        }while (num < 0);

        System.out.println("El número " + num + " tiene " + Integer.toString(num).length() + " dígitos");

    }
}
