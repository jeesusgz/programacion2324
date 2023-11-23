package Tema2.BoletinMatrices;

public class Ejercicio16 {
    public static void main(String[] args) {
        int[][] m1 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 0},
                {3, 2, 1, 4, 5},
                {9, 5, 8, 6, 7},
                {0, 9, 8, 5, 4}
        };
        imprimeMatriz(m1);

        System.out.println();

        int[][] posPares = casillasPares(m1);
        imprimeMatriz(posPares);
    }

    public static int[][] casillasPares(int[][] m){
        int[][] matrizPares = new int[m.length][m[0].length];

        int paresADY = 0;

        for (int fila = 0; fila < m.length; fila++) {
            for (int colum = 0; colum < m[0].length; colum++) {

                for (int miniF = fila - 1; miniF < fila + 2; miniF++) {
                    for (int miniC = colum - 1; miniC < colum + 2; miniC++) {

                        if (miniF >= 0 && miniC >= 0 && miniF < m.length && miniC < m[0].length){

                            if (m[miniF][miniC] % 2 == 0){
                                paresADY++;
                            }
                        }
                    }
                }
                if (m[fila][colum] % 2 == 0){
                    paresADY--;
                }

                matrizPares[fila][colum] = paresADY;
                paresADY = 0;
            }
        }
        return matrizPares;
    }

    public static void imprimeMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%2d ", matriz[i][j]);
            }
            System.out.println();
        }
    }
}
