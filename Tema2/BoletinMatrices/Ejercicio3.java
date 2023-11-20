package Tema2.BoletinMatrices;

import java.util.Arrays;

public class Ejercicio3 {
    public static void main(String[] args) {
        int[][] m = {{1,3,5}, {0,2,7}};

        leerMatrizPorFila(m);
    }

    public static void leerMatrizPorFila(int[][] a){
        System.out.println(" ---> La salida es: ");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
        }
    }
}
