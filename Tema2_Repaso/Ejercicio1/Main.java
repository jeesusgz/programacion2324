package Tema2_Repaso.Ejercicio1;

import MiEntradaSalidaLectora.Lectora;

import java.util.List;

public class Main {
    private static Tienda tienda = new Tienda("VVS Switch de la glopeta");
    public static void main(String[] args) {
        addMascota();
        addMascota();
        addCliente();
        addCompra();
        devolucion();
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

    public static void addCompra(){
        List<Cliente> clientes =  tienda.getListaClientes();
        List<Mascota> mascotas =  tienda.listaDeMascotasDisponibles();
        Cliente c = MiEntradaSalidaLectora.Lectora.leerEnum("selecciona el cliente: ", clientes.toArray(Cliente[]::new));
        Mascota m = MiEntradaSalidaLectora.Lectora.leerEnum("Seleccione a la mascota: ", mascotas.toArray(Mascota[]::new));
        tienda.comprarMascota(c, m);
    }

    public static void devolucion(){
        List<Cliente> clientes = tienda.getListaClientes();
        Cliente c = Lectora.leerEnum("Selecciona el cliente", clientes.toArray(Cliente[]::new));
        List<Compra> compras = tienda.listarComprasClientes(c);
        Compra compra = Lectora.leerEnum("Selecciona la compra", compras.toArray(Compra[]::new));
    }
}
