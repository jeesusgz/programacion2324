package Tema1.Boletin13;

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num;
            System.out.println("Introduce un número entero");
            num = Integer.parseInt(sc.nextLine());

            sc.close();

        if (num % 2 == 0){
            System.out.println("El número es par");
        }else {
            System.out.println("El número es impar");
        }
    }
}
