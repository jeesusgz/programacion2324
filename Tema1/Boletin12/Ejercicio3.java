package Tema1.Boletin12;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce las notas de los examenes");
        double examen = Double.parseDouble(sc.nextLine());
        double examen2 = Double.parseDouble(sc.nextLine());
        double examen3 = Double.parseDouble(sc.nextLine());

        double promedio = (examen + examen2 + examen3) / 3;

        System.out.printf("Tú promedio es %.2f", promedio);
    }
}
