package Tema1.Boletin11;

import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe un número positivo");
        int num = Integer.parseInt(sc.nextLine());

        int suma = 0;

        for (int i = 0; i < num; i++) {
            if (num % i == 0){
                suma += i;
            }
        }

        if (suma == num){
            System.out.println("El número es perfecto");
        }else {
            System.out.println("El número no es perfecto");
        }
    }
}
