package Tema1.Boletin12;

import java.util.Scanner;

public class Ej8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("¿Cúal es tú nivel?");
        int nivel = Integer.parseInt(sc.nextLine());

        System.out.println("¿Cuantas misiones has completado?");
        int mision = Integer.parseInt(sc.nextLine());

        if (nivel > 10 && mision > 20) {
            System.out.println("Tienes acceso a la misión especial");
        } else {
            System.out.println("No cumples los requisitos para la misión especial");
        }
    }
}
