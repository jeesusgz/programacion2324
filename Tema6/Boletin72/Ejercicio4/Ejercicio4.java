package Tema6.Boletin72.Ejercicio4;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio4 {
    public static void main(String[] args) {
        File fichero = new File("./src/Tema6/Boletin72/Ejercicio4/quijote.txt");

        try(BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String linea;
            String patronRazon = "\\braz[oÓ]n\\b";
            Pattern pattern = Pattern.compile(patronRazon, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
            int cont = 0;

            while ((linea = br.readLine()) != null) {
                Matcher m = pattern.matcher(linea);
                while (m.find()) {
                    cont++;
                }
            }
            System.out.println("Número de veces que aparece la palabra 'razón': " + cont);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
