package Tema6_Repaso.Ejercicio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Nio {
    public static void main(String[] args) {
        Path f = Paths.get("./src/Tema6_Repaso/Ejercicio2/file.txt");
        Pattern lineaValida = Pattern.compile(".*[;:]$");
        Pattern matriculaValida = Pattern.compile("(\\d{4}[B-Z&&[^EIOU]]{3})", Pattern.CASE_INSENSITIVE);

        try (Stream<String> lineas = Files.lines(f)){
            lineas.map(lineaValida::matcher)
                    .filter(Matcher::matches)
                    .map(m -> matriculaValida.matcher(m.group(0)))
                    .forEach(m -> {
                        while (m.find()){
                            System.out.println(m.group(1) + " ");
                        }
                        System.out.println();
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
