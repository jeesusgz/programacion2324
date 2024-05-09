package Tema6.Examen2024.Ejercicio1;


import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    /**
     * Puedes utilizar indistintamente java.io o java.nio para resolver los ejercicios.
     *
     * @param args
     */
    public static void main(String[] args) {
        File f = new File("./src/Tema6/Examen2024/Ejercicio1/quijote.txt");

        try {
            ejercicio1(f);
            ejercicio2(f);
            ejercicio3(f);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Para este y los demás apartados puedes cambiar Path por File si lo prefieres.
     *
     * @param path
     */
    public static void ejercicio1(File path) throws IOException {
        File vocales = new File("./src/Tema6/Examen2024/Ejercicio1/palabrasVocales.txt");

        String patronVocales = "\\b[aeiouAEIOUáéíóúÁÉÍÓÚ][a-zA-ZáéíóúÁÉÍÓÚ]*[aeiouAEIOUáéíóúÁÉÍÓÚ]\\b";
        Pattern p = Pattern.compile(patronVocales, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);

        try (BufferedReader br = new BufferedReader(new FileReader(path));
             PrintWriter pw = new PrintWriter(vocales)) {

            String linea;
            while ((linea = br.readLine()) != null) {
                Matcher m = p.matcher(linea);
                while (m.find()) {
                    pw.println(m.group());
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void ejercicio2(File path) {
        File puntuacion = new File("./src/Tema6/Examen2024/Ejercicio1/puntuacion.txt");

        String patronSimbolos = "[.,;:!?-]";
        Pattern p = Pattern.compile(patronSimbolos);

        try (BufferedReader br = new BufferedReader(new FileReader(path));
             PrintWriter pw = new PrintWriter(puntuacion)) {

            String linea;
            while ((linea = br.readLine()) != null) {
                Matcher m = p.matcher(linea);
                while (m.find()) {
                    pw.printf(m.group());
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void ejercicio3(File path) {
        File baseDir = new File("./src/Tema6/Examen2024/Ejercicio1/definiciones");

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String linea;
            while ((linea = br.readLine()) != null) {

                String[] palabras = linea.split("\\s+]");
                for (String palabra : palabras) {
                    if (!palabra.isEmpty()) {
                        String primeraPalabra = String.valueOf(palabra.charAt(0)).toUpperCase();
                        File dir = new File(baseDir + "/" + primeraPalabra);
                        if (!dir.exists()) {
                            dir.mkdir();
                        }
                        File file = new File(dir, palabra + ".txt");
                        if (!file.exists()) {
                            System.out.println(file);
                            file.createNewFile();
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
