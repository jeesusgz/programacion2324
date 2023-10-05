package Tema1.Prueba;

import java.util.Scanner;

public class Teclado {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hola, ¿cómo te llamas?");
        String nombre = sc.nextLine();
        System.out.println("Hola " + nombre);
        System.out.println("¿De donde eres?");
        String lugar = sc.nextLine();
        System.out.println(lugar + ", bonito lugar");
    }
}
