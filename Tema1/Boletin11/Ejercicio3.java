package Tema1.Boletin11;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("¿Cúantos números quieres introducir?");
        int cantidad = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < cantidad; i++) {
            System.out.println("Introduce los números");
            int num = Integer.parseInt(sc.nextLine());
            if (num % 2 == 0) {
                System.out.println("El número es par");
            }else{
                System.out.println("El número es impar");
            }
        }
    }
}
