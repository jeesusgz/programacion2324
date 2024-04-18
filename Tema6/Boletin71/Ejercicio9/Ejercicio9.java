package Tema6.Boletin71.Ejercicio9;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Ejercicio9 {
    public static void main(String[] args) {
        Path path = Paths.get("src/Tema6/Boletin71/Ejercicio9/matriculas.txt");
        Path path2 = Paths.get("src/Tema6/Boletin71/Ejercicio9/matriculasCorrectas.txt");

        Pattern p = Pattern.compile("\\p{L}+\\s(\\d{4}-[A-Z&&[^AEIOU]]{3})");

        try(BufferedWriter writer = Files.newBufferedWriter(path2, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE);
            Stream<String> lineas = Files.lines(path)){

            lineas.map(p::matcher)
                    .filter(Matcher::matches)
                    .forEach(m -> {
                        try {
                            writer.write(m.group());
                            writer.newLine();
                        } catch (IOException e) {
                            System.out.println("Error al escribir el fichero");
                        }
                    });
        }catch (IOException e){
            System.out.println("Error al escribir el fichero");
        }
    }
}
