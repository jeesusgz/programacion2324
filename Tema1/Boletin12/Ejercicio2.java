package Tema1.Boletin12;

import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce los Grados Cº");
        //para poder leer los . y , (Double.parseDouble(sc.nextLine()))
        double gradosC = Double.parseDouble(sc.nextLine());

        double gradosF = (gradosC * 9 / 5) + 32;

        System.out.println("Los grados en celsius es " + gradosC);
        System.out.println("Los grados en Fahrenheit es " + gradosF);
    }
}
