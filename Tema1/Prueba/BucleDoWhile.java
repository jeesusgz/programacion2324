package Tema1.Prueba;

import java.util.Scanner;

public class BucleDoWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String contrasena;
        do {
            System.out.println("Introduce una contraseña");
            contrasena = sc.nextLine();
            //lenght sirve para contar caracteres
        } while (contrasena.length() < 8);

        System.out.println("Has introducido una contraseña correcta");
        sc.close();
    }
}
