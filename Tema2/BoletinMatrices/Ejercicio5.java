package Tema2.BoletinMatrices;

public class Ejercicio5 {
    public static void main(String[] args) {
        int[][] m = {{1,3,5}, {0,2,7}};

        leerMatrizPorFila(m);
    }

    public static void leerMatrizPorFila(int[][] a){
        System.out.println(" ---> La salida es: ");
        for (int j = 0; j < a[0].length; j++) {
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i][j] + " ");
            }
        }
    }
}
