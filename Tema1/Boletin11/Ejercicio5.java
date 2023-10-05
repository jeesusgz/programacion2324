package Tema1.Boletin11;

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int contador = 0;
        int num;

        do {
            System.out.println("Introduce un número (negativo para terminar)");
            num = Integer.parseInt(sc.nextLine());

            if (num >= 0) {
                contador += 1;
            }
        }while(num >= 0);
        System.out.println("Has introducido " + contador + " números positivos");
    }
}
