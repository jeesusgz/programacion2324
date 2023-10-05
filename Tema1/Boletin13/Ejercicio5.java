package Tema1.Boletin13;

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el primer número");
        int num = Integer.parseInt(sc.nextLine());

        System.out.println("Introduce el segundo número");
        int num2 = Integer.parseInt(sc.nextLine());

        System.out.println("Introduce el tercer número");
        int num3 = Integer.parseInt(sc.nextLine());

        System.out.println("Introduce el cuarto número");
        int num4 = Integer.parseInt(sc.nextLine());

        int suma = num + num2 + num3 + num4;
        double media = (double)suma / 4;

        System.out.println("La media de los números es " + media);

        if(media < num){
            System.out.println("El número " + num + " es mayor a la media");
        }
        if (media < num2) {
            System.out.println("El número " + num2 + " es mayor a la media");
        }
        if (media < num3) {
            System.out.println("El número " + num3 + " es mayor a la media");
        }
        if (media < num4) {
            System.out.println("El número " + num4 + " es mayor a la media");
        }
    }
}
