package Tema1.Boletin13;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un número");
        int num = Integer.parseInt(sc.nextLine());

        sc.close();

        if (num % 2 == 0 && num % 3 == 0){
            System.out.printf("El número %d es múltiplo de 2 y de 3", num);
        } else if (num % 2 == 0) {
            System.out.printf("El número %d es múltiplo de 2", num);
        }else {
            System.out.printf("El número %d es múltiplo de 3", num);
        }
    }
}
