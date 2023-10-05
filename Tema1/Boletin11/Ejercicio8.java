package Tema1.Boletin11;

import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double num;
        double menor = Double.MAX_VALUE;

        do {
            System.out.println("Introduce un número");
             num = sc.nextDouble();

            if (num < menor){
                menor = num;
            }
            System.out.println("Quieres introducir más números (s/n)");

            String respuesta = sc.nextLine();
            if (!respuesta.equalsIgnoreCase("s")){
                break;
            }
        }while(true);

        if (menor == Double.MAX_VALUE){
            System.out.println("No has introducido ningun número");
        }else {
            System.out.println("El número menor es " + menor);
        }
    }
}
