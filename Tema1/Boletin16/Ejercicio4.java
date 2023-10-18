package Tema1.Boletin16;

import java.util.Scanner;

public class Ejercicio4 {

    static final int NUM_MAX = 100;
    static final int NUM_MIN = 1;
    static final int NUM_VIDAS = 4;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num;


        //El rango del random siempre es el número máximo que se pide - el mínimo (+1 es para incluir el último)
        int numSecreto = (int) (Math.random() * NUM_MAX) + NUM_MIN;
        System.out.println(numSecreto);
        int vidas = NUM_VIDAS;

        do {
            System.out.println("Introduce un número entre 1-100");
            num = Integer.parseInt(sc.nextLine());
        } while (num > NUM_MAX);


        while (numSecreto != num && vidas != 0) {
            if (num < numSecreto) {

                System.out.println("El número es MENOR al número secreto");
                System.out.println("Introduce un número");
                num = Integer.parseInt(sc.nextLine());
                vidas--;
            } else {
                System.out.println("El número es MAYOR al número secreto");
                System.out.println("Introduce un número");
                num = Integer.parseInt(sc.nextLine());
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
