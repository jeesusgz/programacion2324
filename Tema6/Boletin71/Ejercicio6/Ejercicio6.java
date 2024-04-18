package Tema6.Boletin71.Ejercicio6;

import java.io.File;

public class Ejercicio6 {
    public static void main(String[] args) {
        listarFicherosYpeso();
    }

    public static void listarFicherosYpeso() {
        File[] archivos = new File[]{new File(".\\src\\BoletinFicheros\\Ej6")};
        String nombreArchivo = MiEntradaSalidaLectora.Lectora.solicitarCadenaMinus("Introduce el nombre del archivo: ");
        double pesoArchivo = Double.parseDouble(MiEntradaSalidaLectora.Lectora.solicitarCadenaMinus("Introduce el peso del archivo: "));
        double resultadoPeso = pesoArchivo / 1024;
        System.out.println(resultadoPeso);
        System.out.println(nombreArchivo);
    }
}
