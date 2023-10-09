package Tema1.BoletinExtra;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un número");
        int num = Integer.parseInt(sc.nextLine());

        sc.close();

        int f1 = 0;
        int f2 = 1;
        int f3;


        for (int i = 0; i < num; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        System.out.println("La succesión de Fibonacci de " + num + " es " + f1);
    }
}
