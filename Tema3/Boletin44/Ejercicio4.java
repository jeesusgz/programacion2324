package Tema3.Boletin44;

import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una frase");
        String cadena = sc.nextLine();

        System.out.println("Introduce la palabra escondida: ");
        String palabraEscondida = sc.nextLine();

        if (encuentraPalabras(cadena, palabraEscondida)){
            System.out.println("Encontrada");
        }else {
            System.out.println("No encontrada");
        }
    }

    public static boolean encuentraPalabras(String cadena, String palabraEscondida){
        int contPalabraEncontrada = 0;

        cadena = cadena.toLowerCase();
        palabraEscondida = palabraEscondida.toLowerCase();

        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == palabraEscondida.charAt(contPalabraEncontrada)){
                contPalabraEncontrada++;
            }
            if (contPalabraEncontrada == palabraEscondida.length()){
                break;
            }
        }
        return contPalabraEncontrada == palabraEscondida.length();
    }
}
