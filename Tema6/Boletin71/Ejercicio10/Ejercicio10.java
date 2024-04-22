package Tema6.Boletin71.Ejercicio10;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Ejercicio10 {
    public static void main(String[] args) {
        Path fichOrigin = Paths.get("src/Tema6/Boletin71/Ejercicio10/Fichero.txt");
        Path directorioDesti = Paths.get("src/Tema6/Boletin71/Ejercicio10/");
        Pattern patron = Pattern.compile("^F\\s(\\p{L}{3,}\\.\\p{L}{3})$");
        AtomicBoolean correcto = new AtomicBoolean(true);

        try (Stream<String> lineas = Files.lines(fichOrigin)) {
            lineas.forEach(linea -> {
                Matcher m = patron.matcher(linea);
                if (m.matches()) {
                    try {
                        Files.createFile(directorioDesti.resolve(m.group(1)));
                        System.out.println("Fichero creado: " + m.group(1));
                    } catch (FileAlreadyExistsException e) {
                        System.out.println("El fichero ya existe" + m.group(1));
                    } catch (IOException e) {
                        System.out.println("Error al escribir el fichero" + m.group(1));
                    }
                } else {
                    correcto.set(false);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (correcto.get()) {
            System.out.println("El fichero es correcto");
        }else {
            System.out.println("Alguno de las líneas del fichero no es correcto");
        }
    }
}
