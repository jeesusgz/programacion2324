package Tema1.Boletin11;

import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el primer número");
        int num1 = Integer.parseInt(sc.nextLine());

        System.out.println("Introduce el segundo número");
        int num2 = Integer.parseInt(sc.nextLine());


        sc.close();

        if (num1 < num2) {
            int num3 = num2;
            num2 = num1;
            num1 = num3;
        }

        int resultado = 0;

        for (int i = 0; i < num2; i++) {
            resultado += num1;
        }

        System.out.println("El producto de los números es " + resultado);

    }
}