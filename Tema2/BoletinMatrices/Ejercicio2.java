package Tema2.BoletinMatrices;

public class Ejercicio2 {
    public static void main(String[] args) {
        int[][] m ={{1,1,3},
                    {4,5,7},
                    {8,3,1}
        };

        System.out.println("La suma de la matriz es: " + sumaDeMatriz(m));
    }

    public static int sumaDeMatriz(int[][] m){
        int suma = 0;

        for (int j = 0; j < m.length; j++) {
            for (int i = 0; i < m[0].length; i++) {
                suma += m[i][j];
            }
        }
        return suma;
    }
}
