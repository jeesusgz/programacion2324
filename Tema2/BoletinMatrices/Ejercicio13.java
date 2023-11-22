package Tema2.BoletinMatrices;

public class Ejercicio13 {
    public static void main(String[] args) {
        int[][] m1 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 0},
                {3, 2, 1, 4, 5},
                {9, 5, 8, 6, 7},
                {0, 9, 8, 5, 4}
        };

        imprimeMatrices(m1, invierteMatriz(m1));

    }

    public static int[][] invierteMatriz(int[][] m){
        int[][] invertida = new int[m.length][m[0].length];

        /*
         * Primero comprobaremos que la matriz es cuadrada
         */
        if(m.length == m[0].length) {
            // Al tener el mismo nº de filas que de columnas, es cuadrada
            for (int i = 0; i < m[0].length; i++) {
                for (int j = 0; j < m.length; j++) {
                    invertida[i][j] = m[m.length - 1 - j][m.length - 1 - i];
                }
            }
        }
        else {
            System.out.println("No se invierte la matriz por no ser cuadrada");
        }

        return invertida;
    }

    /**
     * Imprime por consola una matriz de enteros
     * @param matriz
     */
    public static void imprimeMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%2d ", matriz[i][j]);
            }
            System.out.println();
        }
    }

    public static void imprimeMatrices(int[][] m1, int[][] m2) {
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                System.out.printf("%2d ", m1[i][j]);
            }
            /*
             * Hemos impreso la primera matriz, daremos ahora 5 espacios
             * y luego imprimiremos la segunda
             */
            System.out.print("     ");
            for (int j = 0; j < m2[i].length; j++) {
                System.out.printf("%2d ", m2[i][j]);
            }

            // Y luego pasaremos a la fila siguiente
            System.out.println();
        }
    }
}
