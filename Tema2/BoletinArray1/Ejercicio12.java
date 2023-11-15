package Tema2.BoletinArray1;

import java.util.Arrays;

public class Ejercicio12 {
    private static final int MAX_RANDOM = 10;
    public static void main(String[] args) {
        int[] array = generaArrayAleatorio(MAX_RANDOM);
        System.out.println(Arrays.toString(ordBurbuja(array)));
    }

    public static int[] ordBurbuja(int[] a){
        int aux = 0;
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length - i; j++) {
                if (a[j] > a[j + 1]){
                    aux = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = aux;
                }
            }
        }
        return a;
    }

    public static int[] generaArrayAleatorio(int tamArray){
        int[] miArray = new int[tamArray];

        for (int i = 0; i < miArray.length; i++) {
            miArray[i] = (int) (Math.random() * (MAX_RANDOM + 1));
        }

        return miArray;
    }
}
