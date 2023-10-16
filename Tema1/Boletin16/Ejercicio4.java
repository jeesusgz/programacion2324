package Tema1.Boletin16;

import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num;
        do {
            System.out.println("Introduce un número entre 1-100");
            num = Integer.parseInt(sc.nextLine());
        } while (num > 100);

        boolean fallo = false;
        int numSecreto = (int) (Math.random() * 100 + 1);
        int vidas = 4;

        do {
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
        } while (numSecreto != num && vidas != 0);

        if (vidas == 0){
            System.out.println("Te has quedado sin vidas");
            System.out.println("El número secreto era " + numSecreto);
        }else {
            System.out.println("¡¡¡¡¡¡ERE EL VELDADERO DIABLO DE LLORENS!!!!!!");
        }
    }
}
