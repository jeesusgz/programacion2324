package Tema1.Boletin11;

import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tabla;

        do {
            System.out.println("Introduce un número [0-10]");
            tabla = Integer.parseInt(sc.nextLine());
        } while (tabla < 0 || tabla > 10);

        System.out.println("Tabla de " + tabla);

        for (int i = 1; i < 11; i++) {
            int resultado = tabla * i;
            System.out.println(tabla + " * " + i + " = " + resultado);
        }
    }
}
