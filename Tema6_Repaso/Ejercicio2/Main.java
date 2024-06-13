package Tema6_Repaso.Ejercicio2;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        File f = new File("./src/Tema6_Repaso/Ejercicio2/file.txt");

        try(BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linea;

            Pattern lineaValida = Pattern.compile(".*[;:]$");
            Pattern matriculaValida = Pattern.compile("\\d{4}[B-Z&&[^EIOU]]{3}", Pattern.CASE_INSENSITIVE);

            while ((linea = br.readLine()) != null){
                Matcher mLineaValida = lineaValida.matcher(linea);

                if (mLineaValida.matches()){
                    Matcher mMatriculaValida = matriculaValida.matcher(linea);

                    while (mMatriculaValida.find()){
                        System.out.println(mMatriculaValida.group() + " ");
                    }
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no se encuentra");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
