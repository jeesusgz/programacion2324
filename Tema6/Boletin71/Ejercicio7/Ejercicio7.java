package Tema6.Boletin71.Ejercicio7;

import java.io.File;
import java.io.FilePermission;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Ejercicio7 {
    public static File directorio = new File("/Users/Alumno/Desktop");

    public static void main(String[] args) {
        int opcion;
        do {
            menu();
            opcion = MiEntradaSalidaLectora.Lectora.leerEnteroDeRango("Elige una opcion", 6, 0);
            switch (opcion) {
                case 1:
                    listarPorComienzo();
                    break;
                case 2:
                    listarPorExtension();
                    break;
                case 3:
                    buscarArchivo();
                    break;
                case 4:
                    buscarArchivoRecursivo();
                    break;
                case 5:
                    System.out.println("Adiosss!");
                    break;
            }
        } while (opcion != 5);
    }

    public static void menu() {
        System.out.println("1. Listar directorio y buscar ficheros que comiencen por una palabra");
        System.out.println("2. Listar archivos con cierta extensión de un directorio:");
        System.out.println("3. Buscar un archivo en un directorio:");
        System.out.println("4. Buscar recursivamente un archivo en un directorio: ");
        System.out.println("5. salir");
    }


    public static void listarPorComienzo() {
        String palabraBuscada = MiEntradaSalidaLectora.Lectora.solicitarCadenaMinus("Elija la palabra por la que quiere filtrar el fichero ");
        File[] files = directorio.listFiles(((dir, name) -> name.startsWith(palabraBuscada)));
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println(file.getName() + "(Directorio)");
            } else {
                System.out.println(file.getName() + " - " + file.length() / 1024 + "KB");
            }
        }
    }

    public static void listarPorExtension() {
        String palabraFiltrada = MiEntradaSalidaLectora.Lectora.solicitarCadenaMinus("Escriba la extension del fichero que quiere filtrar ");
        Path directorio = Paths.get("/Users/Alumno/Desktop");
        try (Stream<Path> ficheros = Files.list(directorio)) {
            ficheros.filter(Files::isRegularFile)
                    .filter(archivo -> archivo.toString().endsWith("." + palabraFiltrada))
                    .forEach(a -> {
                        try {
                            System.out.println(a.getFileName().toString() + "  " + Files.size(a) / 1024 + " KB ");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            System.out.println("Ocurrio un error al acceder al fichero");
        }

    }

    public static void buscarArchivo() {
        String archivoBuscado = MiEntradaSalidaLectora.Lectora.leerCadena("¿Qué archivo quieres buscar? ");
        Path directorio = Paths.get(".\\src\\Ej7");
        try (Stream<Path> fichero = Files.list(directorio)) {
            fichero.filter(archivo -> archivo.getFileName().toString().equals(archivoBuscado))
                    .filter(Files::isRegularFile)
                    .forEach(a -> {
                        try {
                            System.out.println(a.getFileName() + "  " + Files.size(a) / 1024 + " KB");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void buscarArchivoRecursivo() {
        String palabraBuscada = MiEntradaSalidaLectora.Lectora.leerCadena("Introduce la palabra: ");
        Path dir = directorio.toPath();
        buscarArchivoConcreto(palabraBuscada, dir);
    }

    public static void buscarArchivoConcreto(String nombre, Path directorio) {
        try (Stream<Path> ficheros = Files.list(directorio)){
            ficheros.sorted((directorios, fichero) -> {
                        if (Files.isRegularFile(directorios) && Files.isRegularFile(fichero)){
                            return -1;
                        }else if (Files.isRegularFile(fichero) && Files.isRegularFile(directorios)){
                            return 1;
                        }else {
                            return 0;
                        }
                    })
                    .forEach(a ->{
                        if (Files.isDirectory(a)){
                            buscarArchivoConcreto(nombre, a);
                        }else {
                            if (a.endsWith(Paths.get(nombre))){
                                try {
                                    System.out.println(a.toAbsolutePath() +  " - " + Files.size(a) /1024 + "KB");
                                } catch (IOException e) {
                                    System.out.println("Ocurrio un error al acceder al fichero");
                                }
                            }
                        }
                    });
        } catch (IOException e) {
            System.out.println("Ocurrio un error al acceder al fichero");
        }
    }
}
