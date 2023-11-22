package Tema2.BoletinMatrices;

public class Ejercicio6 {
    public static void main(String[] args) {
        int[][] m = {{1,3,5},
                    {0,2,7}};

        leerMatrizPorFilaInverso(m);
    }

    public static void leerMatrizPorFilaInverso(int[][] a){
        System.out.println(" ---> La salida es: ");
        for (int j = a[0].length - 1; j >= 0; j--) {
            for (int i = a.length - 1; i >= 0; i--) {
                System.out.print(a[i][j] + " ");
            }
        }
    }
}
