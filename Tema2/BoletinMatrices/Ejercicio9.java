package Tema2.BoletinMatrices;

public class Ejercicio9 {
    public static void main(String[] args) {
        int[][] m = {{1,3,5,6},
                {4,2,0,8},
                {4,2,0,8},
                {1,3,5,6}};

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

        //verifico si la matriz sea cuadrada
        if (fila != columna){
            esSimetrica = false;
        }

        for (int i = 0; esSimetrica && i < fila / 2; i++) {
            for (int j = 0; esSimetrica && j < columna; j++) {
                if (m[i][j] != m[fila - 1 - i][j]){
                    esSimetrica = false;
                }
            }
        }
        return esSimetrica;
    }
}
