package Tema2.BoletinArray1;

import EntradaSalida.MiEntradaSalida;

public class Ejercicio6 {

    private static final int MAX_RANDOM = 10;
    public static void main(String[] args) {


        int elementoABuscar = MiEntradaSalida.LeerEnteroPositivo("Introduce el elemento a buscar");
        int[] arrayAleatorio = generaArrayAleatorio(MAX_RANDOM);

        boolean elementoEncontrado = true;

        for (int elem : arrayAleatorio) {
            System.out.println(elem);
            if (elementoABuscar == elem){
                System.out.println(elementoEncontrado = true);
            }else {
                System.out.println(elementoEncontrado = false);
            }
        }
    }

    public static int[] generaArrayAleatorio(int tamArray){
        int[] miArray = new int[tamArray];

        for (int i = 0; i < miArray.length; i++) {
            miArray[i] = (int) (Math.random() * (MAX_RANDOM + 1));
        }

        return miArray;
    }
}
