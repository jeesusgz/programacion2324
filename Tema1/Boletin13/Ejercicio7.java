package Tema1.Boletin13;

import java.util.Scanner;

public class Ejercicio7 {

    static final double RETENCION_SOLTERO_DIVORCIADO = 12;
    static final double RETENCION_MAYORES_50 = 8.5;
    static final double RETENCION_VIUDO_CASADO = 11.3;
    static final double RETENCION_RESTO = 10.5;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un estado civil [S-C-V-D]");
        char estado = sc.nextLine().charAt(0);

        System.out.println("Introduce su edad");
        int edad = Integer.parseInt(sc.nextLine());

        if (estado == 's' && edad < 35 || estado == 'd' && edad < 35){
            System.out.println("Su porcentaje de retención es de " + RETENCION_SOLTERO_DIVORCIADO + " %");
        } else if (edad > 50) {
            System.out.println("Su porcentaje de retención es de " + RETENCION_MAYORES_50 + " %");
        } else if (estado == 'v' && edad < 35 || estado == 'c' && edad < 35) {
            System.out.println("Su porcentaje de retención es de "+ RETENCION_VIUDO_CASADO + " %");
        }else {
            System.out.println("Su porcentaje de retención es de " + RETENCION_RESTO +" %");
        }
    }
}
