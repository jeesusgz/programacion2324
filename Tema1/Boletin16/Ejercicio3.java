package Tema1.Boletin16;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num;
            System.out.println("Introduce un número entero");
            num = Integer.parseInt(sc.nextLine());

        /*
        Transforma un entero en String y cuenta los caractéres que tiene con el .length
         */
        //System.out.println("El número " + num + " tiene " + Integer.toString(num).length() + " dígitos");

        int numB = Math.abs(num);
        int i;

        for (i = 1; numB >= 10; i++) {
            numB /= 10;
        }
        System.out.println("El número " + num + " tiene " + i + " cifras");
    }
}
