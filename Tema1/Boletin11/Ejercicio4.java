package Tema1.Boletin11;

import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num;
        do {
            System.out.println("Introduce un número positivo");
            num = Integer.parseInt(sc.nextLine());
        }while(num <= 0);

        int contador = 0;

        for (int i = 1; i <= num; i++) {
            contador += i;
        }

        System.out.println("La suma de los " + num + " primeros números es " + contador);
    }
}
