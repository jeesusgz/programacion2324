package Tema1.Boletin11;

import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num;

        do{
            System.out.println("Introduce un número entero");
            num = Integer.parseInt(sc.nextLine());
        }while (num < 0);

        int acum = 1;
        for (int i = 2; i <= num; i++) {
            acum *= i;
        }
        System.out.println("El factoria de " + num + " es " + acum);
    }
}
