package Tema6.Boletin71.Ejercicio5;
import EntradaSalida.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;


public class Ejercicio5 {
    public static void main(String[] args) {
        int opcion;
        do {
            menu();
            opcion = MiEntradaSalidaLectora.Lectora.leerEnteroDeRango("Elige una opcion", 6, 0);
            switch (opcion) {
                case 1:
                    crearDirectorio();
                    break;
                case 2:
                    crearArchivoDeTexto();
                    break;
                case 3:
                    borrarFichero();
                    break;
                case 4:
                    mostrarTodosLosFichero2();
                    break;
                case 5:
                    break;
            }
        } while (opcion != 5);
    }

    public static void menu() {
        System.out.println(" 1. Crear directorio ");
        System.out.println("2. Crear fichero Texto");
        System.out.println("3. Borrar Fichero de texto");
        System.out.println("4. Mostar los ficheros que contiene una carpeta");
        System.out.println("5. Mostar los ficheros que contiene una carpeta y su peso ");
        System.out.println("6. salir");
    }

    public static void crearDirectorio() {
        String nombreDirectorio = MiEntradaSalidaLectora.Lectora.solicitarCadenaMinus("introduce el nombre");
        File directorio = new File(".\\src\\BoletinFicheros\\Ej5 " + nombreDirectorio);
        if (directorio.exists()) {
            System.out.println("El directorio ya existe");
        } else {
            if (directorio.mkdir()) {
                System.out.println("Se ha creado correctamente");
            }
        }
    }

    public static void crearArchivoDeTexto() {
        String nombreArchivo = MiEntradaSalidaLectora.Lectora.solicitarCadenaMinus("introduce el nombre");
        File archivoDeTexto = new File(".\\src\\BoletinFicheros\\Ej5 " + nombreArchivo);
        boolean append = true;
        if (archivoDeTexto.exists()) {
            if (archivoDeTexto.isFile()) {
                append = MiEntradaSalidaLectora.Lectora.leerCaracterSN("Quieres añadir el contenido al final del fichero?") == 'S';
            } else {
                System.out.println("No se ha creado el fichero porque ya hay un directorio con el mismo nombre");
                return;
            }
        }
        String cadena = MiEntradaSalidaLectora.Lectora.solicitarCadenaMinus("Escriba la cadena que estará en el fichero");
        try (PrintWriter pr = new PrintWriter(new FileWriter(archivoDeTexto, append))) {
            pr.println(cadena);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void borrarFichero() {
        String nombreArchivo = MiEntradaSalidaLectora.Lectora.solicitarCadenaMinus("introduce el nombre");
        File archivoBorrar = new File(".\\src\\BoletinFicheros\\Ej5 " + nombreArchivo);
        if (!archivoBorrar.exists()) {
            System.out.println("El nombre del fichero no existe");
        } else {
            if (archivoBorrar.delete()) {
                System.out.println("Se ha borrado, el fichero o directorio: " + archivoBorrar.getName());
            } else {
                System.out.println("El fichero no ha podido ser borrado");
            }
        }

    }

    public static void mostrarTodosLosFichero() {
        String nombreArchivo = MiEntradaSalidaLectora.Lectora.solicitarCadenaMinus("introduce el nombre");
        File directorio = new File(".\\src\\BoletinFicheros\\Ej5 " + nombreArchivo);
        if (directorio.exists()) {
            if (directorio.isDirectory()) {
                File[] fichero = directorio.listFiles();
                if (fichero.length > 0) {
                    for (File fich : fichero) {
                        System.out.println("Nombre Fichero: " + fich.getName());
                    }
                } else {
                    System.out.println("El directorio esta vacio");
                }
            }
        } else {
            System.out.println("El nombre del directorio no existe");
        }
    }

    public static void mostrarTodosLosFichero2() {
        String nombreArchivo = MiEntradaSalidaLectora.Lectora.solicitarCadenaMinus("introduce el nombre");
        File directorio = new File(".\\src\\BoletinFicheros\\Ej5 " + nombreArchivo);
        if (directorio.exists()) {
            if (directorio.isDirectory()) {
                File[] ficheros = directorio.listFiles(File::isFile);
                if (ficheros.length > 0) {
                    for (File fich : ficheros) {
                        System.out.println("Nombre Fichero: " + fich.getName());
                    }
                } else {
                    System.out.println("El directorio esta vacio");
                }
            }
        } else {
            System.out.println("El nombre del directorio no existe");
        }
    }

    public static void mostrarTodosLosFichero3() throws IOException {
        String nombreArchivo = MiEntradaSalidaLectora.Lectora.solicitarCadenaMinus("introduce el nombre");
        Path path = Paths.get(".\\src\\BoletinFicheros\\Ej5 " + nombreArchivo);
        if (Files.exists(path) && Files.isDirectory(path)) {
            Files.list(path).filter(Files::isRegularFile).forEach(System.out::println);
        } else {
            System.out.println("El nombre del directorio no existe");
        }
    }
}
