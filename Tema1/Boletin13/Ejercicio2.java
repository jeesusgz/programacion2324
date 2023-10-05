package Tema1.Boletin13;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el primer número");
        int num = Integer.parseInt(sc.nextLine());

        System.out.println("Introduce el segundo número");
        int num2 = Integer.parseInt(sc.nextLine());

        sc.close();

        if (num == num2){
            System.out.println("El número es igual");
        } else if (num < num2) {
            System.out.println("El primer número es menor");
        }else {
            System.out.println("El primer número es mayor");
        }
    }
}
