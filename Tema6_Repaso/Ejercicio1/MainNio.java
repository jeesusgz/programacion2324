package Tema6_Repaso.Ejercicio1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class MainNio {
    public static void main(String[] args) {
        Path f = Paths.get("./src/Tema6_Repaso/Ejercicio1/file");

        try (Stream<String> lineas = Files.lines(f)){
            lineas.forEach(l -> {
                System.out.printf("%d: %s\n", l.split(" ").length, l);
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
