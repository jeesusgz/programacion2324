package Tema2.BoletinArray1;

import java.util.Arrays;

public class Ejercicio10 {
    public static void main(String[] args) {
        int[] a1 = {1,2,3};
        int[] a2 = {5,1,5};

       int[] a3 = eliminaDuplicado(a1, a2);

        System.out.println(Arrays.toString(a3));
    }

    public static int[] eliminaDuplicado(int[] a1, int[] a2){
        int[] a3 = new int[a2.length];
        int elementosAñadidos = 0;

        for (int i = 0; i < a2.length; i++) {
            if (indexOf(a1, a2[i]) == -1){
                a3[elementosAñadidos++] = a2[i];
            }
        }

        int[] a4 = new int[elementosAñadidos];

        for (int i = 0; i < elementosAñadidos; i++) {
            a4[i] = a3[i];
        }

        return a4;
    }

    public static int indexOf(int[] a, int elem){
        int pos = -1;
        for (int i = 0; i < a.length && pos == -1; i++) {
            if (a[i] == elem){
                pos = 1;
            }
        }
        return pos;
    }
}
