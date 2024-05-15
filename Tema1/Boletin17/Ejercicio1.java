package Tema1.Boletin17;

import MiEntradaSalidaLectora.Lectora;

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        int num = Lectora.leerEnteroPositivo("Introduce un número positivo");

       int inverso = 0;

       while(num != 0){
           inverso = inverso * 10 + num % 10;
           num /=10;
        }
        System.out.println(inverso);
    }
}
