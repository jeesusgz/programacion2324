package Tema1.Boletin12;

import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la distancia de tu destino");
        double distancia = Double.parseDouble(sc.nextLine());

        System.out.println("Introduce tu velocidad");
        double velocidad = Double.parseDouble(sc.nextLine());

        double tiempo = distancia / velocidad;



        int hora = (int)tiempo;
        int min = (int) ((tiempo - hora) * 60);
        int seg = (int)(((tiempo * 60) - (hora * 60) - min) * 60);

        System.out.printf("El camino durará %d : %d : %d", hora, min, seg);
    }
}
