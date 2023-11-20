package Tema2.BoletinMatrices;

public class Ejercicio7 {
    public static void main(String[] args) {
        int[][] m = {{1,3,5},
                {0,2,5}
        };
        int[][] m2 = {{1,3,5},
                {0,2,7}
        };

        if (comprobarMatrizIgual(m,m2)){
            System.out.println("La matrices son iguales");
        }else {
            System.out.println("Las matrices NO son iguales");
        }

    }

    public static boolean comprobarMatrizIgual (int[][] m, int[][] m2){
        boolean esIgual = false;

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    for (int l = 0; l < m2[k].length; l++) {
                        if (m[i][j] == m2[k][l]){
                            esIgual = true;
                        }
                    }
                }
            }
        }
        return esIgual;
    }
}
