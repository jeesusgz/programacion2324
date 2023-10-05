package Tema1.Boletin12;

import java.util.Scanner;

public class Ej13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce tu comida rápida favorita (Hamburguesa, Pizza, Tacos, Ensalada)");
        String comida = sc.nextLine();

        switch (comida){
            case "Hamburguesa":
                System.out.println("ten cuidaito que te va a morir si come mucho deso tu sabe ermano cuidate");
                break;
            case "Pizza":
                System.out.println("dime porfavo que no ere de esa gente rara que le gusta con piña");
                break;
            case "Taco":
                System.out.println("que eres panchito o q");
                break;
            case "Ensalada":
                System.out.println("illo ere un tonto");
                break;
            default:
                System.out.println("Introduce una comida válida");
        }
    }
}
