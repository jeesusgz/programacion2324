package Tema2.BoletinMatrices;

public class Ejercicio10 {
    public static void main(String[] args) {
        int[][] m = {{1,3,5,6},
                {4,2,0,8},
                {4,2,0,8},
                {1,3,5,6}};
        int[][] m2 = {{1,3,5},
                {0,2,7}};

        if (esMatrizSimetricaEnX(m)){
            System.out.println("La matriz es simetrica en función del eje Y");
        }else {
            System.out.println("La matriz NO es simetrica en función del eje Y");
        }
    }

    public static boolean esMatrizSimetricaEnX(int[][] m){
        boolean esSimetrica = true;

        int fila = m.length;
        int columna = m[0].length;

        for (int j = 0; esSimetrica && j < columna / 2; j++) {
            for (int i = 0; esSimetrica && i < fila; i++) {
                if (m[i][j] != m[i][columna - 1 - j]){
                    esSimetrica = false;
                }
            }
        }
        return esSimetrica;
    }
}
