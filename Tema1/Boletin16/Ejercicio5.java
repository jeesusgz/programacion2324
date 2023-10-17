package Tema1.Boletin16;

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un número");
        int num = Integer.parseInt(sc.nextLine());

        boolean noEsPrimo = false;

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                noEsPrimo = true;
                break;
            }
        }

        if (noEsPrimo) {
            System.out.println("El número " + num + " NO es primo");
        }else {
            System.out.println("El número " + num + " ES primo");
        }
    }
}
