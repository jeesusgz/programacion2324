package Tema1.Boletin13;

import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int hora;
        int min;
        int sec;
        int hora1;
        int min1;
        int sec1;
        do {
            System.out.println("Introduce una hora");
            hora = Integer.parseInt(sc.nextLine());

            System.out.println("Introduce los minutos");
            min = Integer.parseInt(sc.nextLine());

            System.out.println("Introduce los segundos");
            sec = Integer.parseInt(sc.nextLine());

            System.out.println("Introduce una segunda hora");
            hora1 = Integer.parseInt(sc.nextLine());

            System.out.println("Introduce los minutos");
            min1 = Integer.parseInt(sc.nextLine());

            System.out.println("Introduce los segundos");
            sec1 = Integer.parseInt(sc.nextLine());

        }while(hora < 0 || hora >= 23 && min < 0 || min >= 59 && sec >= 0 || sec < 59
                && hora1 < 0 || hora1 >= 23 && min1 < 0 || min1 >= 59 && sec1 >= 0 || sec1 < 59);

        if (hora > hora1){
            System.out.println("Hora 1 es mayor");
        }else {
            System.out.println("Hora 2 es mayor");
        }



    }

}
