package Tema2.BoletinArray1;

import java.util.Random;

public class Ejercicio4 {
    private static final int NUM_REPETICIONES = 6000;
    private static final int MIN_RANDOM = 0;
    private static final int MAX_RANDOM = 100;
    public static void main(String[] args) {
        Random rnd = new Random();
        int suma = 0;

        //crea el array de 10 posicones para guardar cuantas veces se repite los últimos números
        int[] terminaciones = new int[10];

        //creacion de los 6000 números aleatorios
        for (int i = 0; i < NUM_REPETICIONES; i++) {
            int aleatorio = rnd.nextInt(MAX_RANDOM);
            suma += aleatorio;

            //suma el último dígito y lo añade a la posición del array
            terminaciones[aleatorio % 10]++;
        }

        int posMax = 0;
        int maxValue = Integer.MIN_VALUE;

        //Este for voy a mostrar el número de veces que se ha repetido el último dígito
        for (int i = 0; i < terminaciones.length; i++) {
            System.out.printf("El número %d se ha repetido %d veces. Esto equivale a un %.2f%%\n",
                    i,
                    terminaciones[i],
                    (double)terminaciones[i] / NUM_REPETICIONES * 100);
        }

        //En este for busco el dígito en el que han terminado más números
        for (int i = 0; i < terminaciones.length; i++) {
            if (terminaciones[i] > maxValue){
                maxValue = terminaciones[i];
            }
        }

        /*
        si un número se repite el máximo número de veces vuelve a recorrer el array por si otro número
        se ha repetido el máximo número de veces
         */
        for (int i = 0; i < terminaciones.length; i++) {
            if (terminaciones[i] == maxValue){
                System.out.printf("El dígito %d es el que más números han terminado (%d veces)\n", i, maxValue);
            }
        }
        System.out.printf("La media de los números es %.2f\n", (double)suma / NUM_REPETICIONES);


        //Este for sirve para comproobar que un número no se haya repetido
        for (int i = 0; i < terminaciones.length; i++) {
            if (terminaciones[i] == 0){
                System.out.printf("No ha habído ningún número que terminase en %d\n", i);
            }
        }
    }
}
