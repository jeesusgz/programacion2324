package Tema2.BoletinMatrices;

public class Ejercicio14 {
    public static void main(String[] args) {
        int[][] m1 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 0},
                {3, 2, 1, 4, 5},
                {9, 5, 8, 6, 7},
                {0, 9, 8, 5, 4}
        };

        imprimeMatrices(m1, convertirFilaEnColumna(m1));
    }

    public static int[][] convertirFilaEnColumna(int[][] m){
        int[][] convertida = new int[m.length][m[0].length];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
               convertida[i][j] = m[j][i];
            }
        }
        return convertida;
    }

    public static void imprimeMatrices(int[][] m1, int[][] m2) {
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                System.out.printf("%2d ", m1[i][j]);
            }
            System.out.print("     ");
            for (int j = 0; j < m2[i].length; j++) {
                System.out.printf("%2d ", m2[i][j]);
            }

            System.out.println();
        }
    }
}
