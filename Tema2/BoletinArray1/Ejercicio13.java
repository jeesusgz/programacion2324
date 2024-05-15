package Tema2.BoletinArray1;

import MiEntradaSalidaLectora.Lectora;

import java.util.Arrays;

public class Ejercicio13 {

    public static final int TAM_PiLA = 10;
    public static int[] pila = new int[TAM_PiLA];
    public static int ultimoElemento = 0;
    public static void main(String[] args) {

        int opcion = 0;

        while (opcion != 4){
            menu();
            opcion = Lectora.leerEnteroDeRango("Introduce una opción", 1, 4);

            switch (opcion) {
                case 1 -> {
                    int num = Lectora.leerCaracter("Introduce un número");
                    apilar(num);
                }
                case 2 -> {
                    int numDesapilado = desapilar();
                    System.out.println("Has desapilado el número " + numDesapilado);
                }
                case 3 -> {
                    mostrarPila();
                }
                case 4 -> System.out.println("Adiós");
                default -> System.out.println("Elige una opción válida");
            }
        }
    }

    public static void apilar (int num){
        if (ultimoElemento !=pila.length - 1){
            pila[ultimoElemento] = num;
            ultimoElemento++;
            }else {
            System.out.println("No se puede apilar más, la pila está llena");
        }
    }

    public static int desapilar (){
        if (ultimoElemento == 0){
            System.out.println("No hay nada que desapilar");
        }else {
            ultimoElemento--;
        }
        return pila[ultimoElemento];
    }

    public static void mostrarPila(){
        System.out.println(Arrays.toString(pila));
    }

    public static void menu(){
        System.out.println("¿Qué deseas hacer?");
        System.out.println("1) Apilar");
        System.out.println("2) desapilar");
        System.out.println("3) Mostrar");
        System.out.println("4) salir");
    }
}
