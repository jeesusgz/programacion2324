package Tema3.Boletin44;

import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una frase");
        String cadena = sc.nextLine();
        sc.close();

        System.out.println(contarCaracteres(cadena));
    }

    public static int contarCaracteres(String cadena){
        int numActual = 0;
        int acum = 0;

        for (int i = 0; i < cadena.length(); i++) {
            if (Character.isDigit(cadena.charAt(i))){
                numActual = numActual * 10 + Integer.parseInt(cadena.charAt(i)+ "");
            }else {
                if (numActual > 0){
                    acum += numActual;
                    numActual = 0;
                }
            }
        }
        return acum + numActual;
    }
}
