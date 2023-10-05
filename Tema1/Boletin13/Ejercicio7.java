package Tema1.Boletin13;

import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Introduce un estado civil [S-C-V-D]");
        char estado = sc.nextLine().charAt(0);

        System.out.println("Introduce su edad");
        int edad = Integer.parseInt(sc.nextLine());

        if (estado == 's' && edad < 35 || estado == 'd' && edad < 35){
            System.out.println("Su porcentaje de retención es de 12%");
        } else if (edad > 50) {
            System.out.println("Su porcentaje de retención es de 8.5%");
        } else if (estado == 'v' && edad < 35 || estado == 'c' && edad < 35) {
            System.out.println("Su porcentaje de retención es de 11.3%");
        }else {
            System.out.println("Su porcentaje de retención es de 10.5%");
        }
    }
}
