package Tema6.Boletin71.Ejercicio8;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio8 {
    public static void main(String[] args) {
        Path path = Paths.get("src/Tema6/Boletin71/Ejercicio8/Fichero.txt");

        Pattern pattern = Pattern.compile("((?:\\p{L}{2,}\\s{3})(([1-9][0-9]?)|0[1-9]))");

        try(BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)){
            if (reader.lines().map(pattern::matcher).allMatch(Matcher::matches)){
                System.out.println("El fichero cumple con el patrón");
            }else {
                System.out.println("El fichero no cumple con el patrón");
            }
        }catch (IOException e){
            System.out.println("Error al leer el fichero");
        }
    }
}
