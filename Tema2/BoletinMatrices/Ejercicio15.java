package Tema2.BoletinMatrices;

import java.util.Scanner;

public class Ejercicio15 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int[][] m1 = {
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30}
        };

        System.out.println(coordenadas(m1));
    }

    public static int coordenadas(int[][] m1){
        int fila;
        do {
            System.out.printf("Introduce una fila empezando por 0 (La matriz tiene %d filas ): ", m1.length);
            fila = Integer.parseInt(sc.nextLine());
        }while(fila < 0 || fila >= m1.length);

        int columna;
        do {
            System.out.printf("Introduce una columna empezando por 0 (La matriz tiene %d columnas): ", m1[0].length);
            columna = Integer.parseInt(sc.nextLine());
        }while(columna < 0 || columna >= m1[0].length);

        int coordenada = (fila * m1[0].length) + columna + 1;
        return coordenada;
    }


}
