package Tema1.Prueba;

import java.util.Scanner;

public class BucleWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un número");
        int num = Integer.parseInt(sc.nextLine());
        int i = 2;

        while (num % i != 0) {
            i++;
        }
        if (num == i) {
            System.out.println(i + " es un número primo");
        }else {
            System.out.println("El primer divisor es: " + i);
        }
    }
}
