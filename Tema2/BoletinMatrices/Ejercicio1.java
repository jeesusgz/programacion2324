package Tema2.BoletinMatrices;

public class Ejercicio1 {
    public static void main(String[] args) {
        int[][] m = {{1,3,5}, {0,-2,7}};

        if (comprobarNumNegtivo(m)){
            System.out.println("Hay números negativos");
        }else {
            System.out.println("NO hay números negativos");
        }
    }

    public static boolean comprobarNumNegtivo(int[][] a){
        boolean esNegativo = false;

        for (int i = 0; i < a.length && !esNegativo; i++) {
            for (int j = 0; j < a[i].length && !esNegativo; j++) {
                if (a[i][j] < 0){
                    esNegativo = true;
                }
            }
        }
        return esNegativo;
    }
}
