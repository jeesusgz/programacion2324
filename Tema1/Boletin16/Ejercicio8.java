package Tema1.Boletin16;

import MiEntradaSalidaLectora.Lectora;

public class Ejercicio8 {
    public static void main(String[] args) {
        int a = Lectora.leerCaracter("Introduce el coeficiente A");
        int b = Lectora.leerCaracter("Introduce el coeficiente B");
        int c = Lectora.leerCaracter("Introduce el coeficiente C");

        int discriminante = b * b - 4 * a * c;

        if (discriminante > 0){
            System.out.println("hay dos soluciones reales");
        }
        if (discriminante < 0){
            System.out.println("no hay solución real");
        }
        if (discriminante == 0){
            System.out.println("hay una solución real");
        }
    }
}
