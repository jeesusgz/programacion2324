package Tema6_Repaso.Ejercicio1;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        File f = new File("./src/Tema6_Repaso/Ejercicio1/file");

        try(BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linea;
            while ((linea = br.readLine()) != null){
                String[] palabras = linea.split("\\s+");
                int numPalabras = palabras.length;
                System.out.printf(numPalabras + ": ");
                System.out.println(linea);

            }

        } catch (FileNotFoundException e) {
            System.out.println("El archivo no se encuentra");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
