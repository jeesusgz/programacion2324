package Tema2.BoletinMatrices;

public class Ejercicio7 {
    public static void main(String[] args) {
        int[][] m = {{1,3,5},
                    {0,2,7}
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

    public static boolean comprobarMatrizIgual(int[][] m, int[][] m2){
        boolean esIgual= true;

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] != m2[i][j]){
                    esIgual = false;
                }
            }
        }
        return esIgual;
    }
}
