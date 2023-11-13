package Tema2.BoletinArray1;

import EntradaSalida.MiEntradaSalida;

public class Ejercicio7 {
    private static final int MAX_RANDOM = 10;
    public static void main(String[] args) {
        int num = MiEntradaSalida.LeerEnteroPositivo("Introduce el valor que deseas buscar");
        int tamArray = MiEntradaSalida.LeerEnteroPositivo("Introduce el tamaño del array");
        int[] array = generaArrayAleatorio(tamArray);

        if (contieneElemento(array, num)){
            System.out.println("Se ha encontrado el valor");
        }else {
            System.out.println("No se ha encontrado el valor");
        }
    }

    public static boolean contieneElemento(int[]a, int b){
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b){
                return true;
            }
        }
        return false;
    }

    public static int[] generaArrayAleatorio(int tamArray){
        int[] miArray = new int[tamArray];

        for (int i = 0; i < miArray.length; i++) {
            miArray[i] = (int) (Math.random() * (MAX_RANDOM + 1));
        }

        return miArray;
    }
}
