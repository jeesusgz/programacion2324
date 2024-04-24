package Tema6.Boletin71.Ejercicio11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Ejercicio11 {

    public static void main(String[] args) {
        Path fichero = Paths.get(".\\src\\Tema6\\boletin71\\Ejercicio11\\Fichero.txt");
        Pattern patron =
                Pattern.compile("(\\p{Lu}{2,})\\s(\\p{Lu}{2,})\\s(\\p{Lu}{2,})\\s([^\\\\\\\\/:\\\"*?<>|\\n]{2,})");
        String directorio = ".\\src\\Tema6\\boletin71\\Ejercicio11\\pruebaEjercicio11";

        try(Stream<String> lineas = Files.lines(fichero)){
            lineas.map(patron::matcher)
                    .filter(Matcher::matches)
                    .forEach(m -> {
                        String nombreAlumno = m.group(2) + m.group(3) + m.group(1);

                        try {
                            Files.createDirectories(Path.of(directorio,m.group(4), nombreAlumno));
                        } catch (IOException e) {
                            System.out.println(e);
                        }
                    });
        } catch (IOException e) {
            System.out.println("Fichero no encontrado");
        }
    }
}
