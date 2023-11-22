package Tema2.BoletinMatrices;

public class Ejercicio11 {
    public static void main(String[] args) {
        int[][] m = {{5,8,9,0},
                    {4,7,5,2},
                    {1,7,3,2}};
        int[][] m2 = {{2,3,7,1},
                    {2,5,7,4},
                    {0,9,8,5}};

        if (comprobarInversa(m, m2)){
            System.out.println("Las matrices son inversas");
        }else {
            System.out.println("las matrices NO son inversas");
        }
    }
    
    public static boolean comprobarInversa(int[][] a, int[][] b){
        boolean comprobar = a.length == b.length;

        for (int i = 0; i < a.length && comprobar; i++) {
            comprobar = a[i].length == b[a.length - 1 - i].length;
            for (int j = 0; j < a[i].length && comprobar; j++) {
                if (a[i][j] != b[a.length - 1 - i][a[i].length - 1 - j]){
                    comprobar = false;
                }
            }
        }
        return comprobar;
    }
}
