package Tema6.Boletin71.Ejercicio4;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Ejercicio4 {
    public static void main(String[] args) {
       /* try (BufferedReader inputStream = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter outputStream = new PrintWriter(new FileWriter(".\\src\\BoletinFicheros\\salidaEj3.txt", true ));){
            String l;
            while (!(l = inputStream.readLine()).equals("fin")) {
                outputStream.println(l);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        */

        Path path = Paths.get(".\\src\\Tema6\\Boletin71\\Ejercicio4\\FicheroNuevo.txt");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            String l;
            while (!(l = br.readLine()).equals("fin")) {
                Files.writeString(path, l, StandardOpenOption.APPEND);


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
