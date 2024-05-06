package Tema6.Examen2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la carpeta original: ");
        Path origen = Paths.get(sc.nextLine());

        System.out.println("Introduce la carpeta destino: ");
        Path destino = Paths.get(sc.nextLine());

        if (!Files.isDirectory(origen)){
            System.out.println("La carpeta origen no existe");
            return;
        }else {
            if (!Files.isReadable(origen)){
                System.out.println("La carpeta origen no se puede leer");
                return;
            }
        }

        if (!Files.isDirectory(destino)){
            System.out.println("La carpeta destino no existe");
            return;
    }else {
            if (!Files.isReadable(destino)){
                System.out.println("La carpeta destino no se puede leer");
                return;
            }
        }

        try(Stream<Path> flujo = Files.list(origen)){
            flujo.filter(path -> {
                try{
                    if (Files.size(path) > 1024 && Files.isRegularFile(origen) && path.getFileName().toString().endsWith(".txt")){
                        try (BufferedReader br = Files.newBufferedReader(path)){
                            if (br.readLine().toLowerCase().startsWith("copiar")){
                                return true;
                            }
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Error al leer el archivo ");
                }
                return false;
            }).forEach(path -> {
                try {
                    Files.copy(path, destino.resolve(path.getFileName()));
                } catch (IOException e) {
                    System.out.println("Error al copiar el archivo " + path.getFileName());
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
