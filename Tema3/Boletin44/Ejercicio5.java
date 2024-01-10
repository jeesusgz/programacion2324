package Tema3.Boletin44;

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la frase original");
        String sentence = sc.nextLine();

        System.out.println("Introduce el texto a buscar");
        String word1 = sc.nextLine();

        System.out.println("Introduce el texto que reemplaza");
        String word2 = sc.nextLine();

        System.out.println("\n" + reemplazaExpresion(sentence, word1, word2));
    }

    private static String reemplazaExpresion(String frase, String reemplazado, String reemplazador){

        for (int i = frase.indexOf(reemplazado); i != -1; i += reemplazador.length()) { //TODO revisar última letra error

        }
    }
}
