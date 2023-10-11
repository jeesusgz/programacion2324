package Tema1.Boletin14;

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num;
        int cont = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int suma = 0;

        do{
            System.out.println("Introduce un número (Para salir inserte -1)");
            num = Integer.parseInt(sc.nextLine());

            if (num <= -1){
                break;
            }else {
                cont++;
                suma += num;

                if (num > max){
                    max = num;
                }

                if (num < min){
                    min = num;
                }
            }
        }while(true);

        double media = (double) suma / cont;

        System.out.println("La media de los " + cont + " números es " + media);
        System.out.println("El valor máximo de los números es " + max + " y el valor mínimo es " + min);

    }
}
