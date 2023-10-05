package Tema1.Prueba;

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una palabra");
        String palabra1 = sc.nextLine();
        System.out.println("Introduce otra palabra");
        String palabra2 = sc.nextLine();
        System.out.println(palabra1 + " y " + palabra2);
    }
}
