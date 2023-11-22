package Tema2.BoletinMatrices;

import java.util.Arrays;
//no va
public class Ejercicio8 {
    public static void main(String[] args) {
        int[][] m = {{1,3,5},
                    {0,2,7}};
        int[][] m2 = {{1,3,5},
                    {0,2,7}};

        System.out.print(Arrays.toString(m[0]) + " + ");
        System.out.print(Arrays.toString(m[0]) + " = ");
        System.out.print(Arrays.toString(m[1]) + " + ");
        System.out.print(Arrays.toString(m[1]) + " = ");
        sumMatriz(m,m2);
    }

    public static int[][] sumMatriz(int[][] m, int[][] m2){
        int[][] sumMatrices = new int[m.length][m[0].length];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                sumMatrices[i][j] = m[i][j] + m2[i][j];
            }
        }
        return sumMatrices;
    }


}
