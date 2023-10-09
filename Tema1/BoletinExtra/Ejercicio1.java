package Tema1.BoletinExtra;

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un número");
        int num = Integer.parseInt(sc.nextLine());

        System.out.println("Introduce un segundo número");
        int num2 = Integer.parseInt(sc.nextLine());

        sc.close();

        boolean primosEntreSi = true;

        for (int i = 2; i < num && i < num2 && primosEntreSi ; i++) {
            if (num % i == 0 && num2 % i == 0){
                System.out.println("No son primos entre si, " + i + " divide a " + num + " y " + num2);
                primosEntreSi = false;
            }
        }
        if (primosEntreSi){
            System.out.println("Los números " + num + " y " + num2 + " son primos entre si");
        }
    }
}