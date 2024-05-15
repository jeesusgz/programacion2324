package Tema2.BoletinArray1;

import MiEntradaSalidaLectora.Lectora;

import java.util.Arrays;

public class Ejercicio5 {

    private static final int MAX_RANDOM =  1000;
    public static void main(String[] args) {
        int tamArray = Lectora.leerEnteroPositivo("Introduce el tamaño del array");

        int[] arrayAleatorio = generaArrayAleatorio(tamArray);

        for (int elem : arrayAleatorio) {
            System.out.println(elem);
        }

        //Expresión lambda
        //Arrays.stream(arrayAleatorio).sorted().forEach(System.out::println);
    }

    public static int[] generaArrayAleatorio(int tamArray){
        int[] miArray = new int[tamArray];

        for (int i = 0; i < miArray.length; i++) {
            miArray[i] = (int) (Math.random() * (MAX_RANDOM + 1));
        }

        return miArray;
    }
}
