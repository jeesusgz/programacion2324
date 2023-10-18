package Tema1.Boletin16;

import java.util.Scanner;

public class Ejercicio4 {

    static final int NUM_MAX = 100;
    static final int NUM_MIN = 1;
    static final int NUM_VIDAS = 5;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = NUM_MIN - 1;


        //El rango del random siempre es el número máximo que se pide - el mínimo (+1 es para incluir el último)
        int numSecreto = (int) (Math.random() * NUM_MAX) + NUM_MIN;
        System.out.println(numSecreto);
        int vidas = NUM_VIDAS;




        while (numSecreto != num && vidas != 0) {
            do {
                System.out.println("Introduce un número entre 1-100");
                num = Integer.parseInt(sc.nextLine());
            } while (num > NUM_MAX);

            if (num < numSecreto) {

                System.out.println("El número es MENOR al número secreto");
                vidas--;
            } else if (num > numSecreto){
                System.out.println("El número es MAYOR al número secreto");
                vidas--;
            }
        }
        if (vidas == 0) {
            System.out.println("Te has quedado sin vidas");
            System.out.println("El número secreto era " + numSecreto);
        } else {
            System.out.println("¡¡¡¡¡¡ERE EL VELDADERO DIABLO DE LLORENS!!!!!!");
        }
    }
}
