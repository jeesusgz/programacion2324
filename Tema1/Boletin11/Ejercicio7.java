package Tema1.Boletin11;

import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cantidad;
        do {
            System.out.println("¿Cúantos números quieres introducir?");
            cantidad = Integer.parseInt(sc.nextLine());
        }while(cantidad < 0);

        int suma = 0;

        for (int i = 1; i <= cantidad; i++) {
            System.out.println("Introduce los números");
            int num = Integer.parseInt(sc.nextLine());

            suma += num;
        }
        double media = (double)suma / cantidad;
        System.out.println("La media es " + media);
    }
}
