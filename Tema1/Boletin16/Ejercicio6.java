package Tema1.Boletin16;

import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numAlumnos;
        do {
            System.out.println("¿Cúantos alumnos hay en la clase?");
            numAlumnos = Integer.parseInt(sc.nextLine());
        }while (numAlumnos < 0);

        int contAprobados = 0;
        int contsuspensos = 0;
        int notas;

        for (int i = 0; i < numAlumnos; i++) {
            do {
                System.out.println("Introduce las notas de los alumnos");
                notas = Integer.parseInt(sc.nextLine());
            }while (notas < 0 || notas > 10);

            if (notas < 5){
                contsuspensos++;
            }else {
                contAprobados++;
            }
        }
        double porcentajeAprobados = (double) contAprobados / numAlumnos * 100;
        double porcentajeSuspensos = (double) contsuspensos / numAlumnos * 100;

        System.out.printf("De %d Alumnos han aprobado %d y suspendido %d",numAlumnos, contAprobados, contsuspensos);
        System.out.println();
        System.out.printf("El porcentaje de aprobados es de %.2f y el de suspensos es de %.2f"
                , porcentajeAprobados, porcentajeSuspensos);
    }
}
