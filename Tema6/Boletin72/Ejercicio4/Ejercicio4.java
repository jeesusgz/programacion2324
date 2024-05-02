package Tema6.Boletin72.Ejercicio4;

import java.io.*;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio4 {
    public static void main(String[] args) {
        File fichero = new File("./src/Tema6/Boletin72/Ejercicio4/quijote.txt");
        File fichero1 = new File("./src/Tema6/Boletin72/Ejercicio4/quijote1.txt");
        File fichero2 = new File("./src/Tema6/Boletin72/Ejercicio4/quijote2.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(fichero));
             PrintWriter pw = new PrintWriter(fichero1)) {

            String linea;
            String patronRazon = "\\braz[oÓ]n\\b";
            Pattern pattern = Pattern.compile(patronRazon, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
            int cont = 0;

            String patronTildes = "[áéíóúñ]";
            Pattern pattern1 = Pattern.compile(patronTildes, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
            int cont1 = 0;

            String patronNum = "(\\p{L})\\d+";
            Pattern pattern2 = Pattern.compile(patronNum, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);

            String patron8Letras= "\\p{LD}{8,}";
            Pattern p3 = Pattern.compile(patron8Letras);

            Pattern p4 = Pattern.compile("\\p{L}+");

            while ((linea = br.readLine()) != null) {
                //Ejercicio1
                Matcher m = pattern.matcher(linea);
                while (m.find()) {
                    cont++;
                }

                //Ejercicio2
                Matcher m2 = pattern1.matcher(linea);
                while (m2.find()) {
                    cont1++;
                }

                //Ejercicio3
                Matcher m3 = pattern2.matcher(linea);
                pw.println(m3.replaceAll("$1"));

                //Ejercicio5
                Matcher m4 = p3.matcher(linea);

                while (m4.find()) {
                    System.out.println(m4.group());
                }

                //Ejercicio6
                Matcher m5 = p4.matcher(linea);
                if (m.results().count() > 15){
                    System.out.println(linea);
                }

             }
            System.out.println("Número de veces que aparece la palabra 'razón': " + cont);

            System.out.println("Número de veces que aparecen las letras con tilde o 'ñ': " + cont1);


        } catch (IOException e) {
            e.printStackTrace();
        }

        //Ejercicio4
        Pattern p =Pattern.compile("\\b(\\p{Ll})(\\p{Ll}*)\\d*\\b");

        try (BufferedReader br = new BufferedReader(new FileReader(fichero1));
             PrintWriter pw = new PrintWriter(fichero2)) {

            String linea;
            while ((linea = br.readLine()) != null) {
               Matcher m = p.matcher(linea);
                pw.println(m.replaceAll(matchResult -> matchResult.group(1).toUpperCase() + matchResult.group(2)));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
