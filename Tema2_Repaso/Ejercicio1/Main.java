package Tema2_Repaso.Ejercicio1;

import MiEntradaSalidaLectora.Lectora;

public class Main {
    private static Tienda tienda = new Tienda("VVS Switch de la glopeta");
    public static void main(String[] args) {
        addCliente();
        addMascota();
    }

    public static void addCliente(){
        tienda.addCliente(Lectora.solicitarCadenaMinus("Introduce el nombre del cliente: "));
    }

    public static void addMascota(){
        String nombre = Lectora.solicitarCadenaMinus("Introduce el nombre de la mascota: ");
        int edad = Lectora.leerEnteroPositivo("Introduce la edad de la mascota: ");
        double precio = Lectora.leerDouble("Introduce el precio de la mascota: ");
        Especie especie = Lectora.leerEnum("Que tipo de mascota es: ", Especie.values());
        boolean disponible = Lectora.leerCaracterSN("La mascota esta disponible? (S/N): ") == 'S';

        tienda.addMascota(nombre, especie, edad, precio, disponible);
    }
}
