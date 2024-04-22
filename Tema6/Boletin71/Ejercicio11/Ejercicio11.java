package Tema6.Boletin71.Ejercicio11;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class Ejercicio11 {

    public static void main(String[] args) {
        Path fichero = Paths.get(".\\src\\boletin71\\Fichero.txt");
        Pattern patron = Pattern.compile("(\\p{Lu}{2,})\\s(\\p{Lu}{2,})\\s(\\p{Lu}{2,})\\s([^\\\\/:\"\\*\\?|<>])");
    }
}
