package Tema2_Repaso.Ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Tienda {
    private String nombre;
    private List<Mascota> listaMascotas;
    private List<Cliente> listaClientes;
    private List<Compra> listaCompra;

    public Tienda(String nombre) {
        this.nombre = nombre;
        this.listaMascotas = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
        this.listaCompra = new ArrayList<>();
    }

    public void addCliente(String nombre) {
        Cliente cliente = new Cliente(nombre);
        listaClientes.add(cliente);
    }

    public void addMascota(String nombre, Especie especie, int edad, double precio, boolean disponible) {
        Mascota mascota = new Mascota(nombre, especie, edad, precio, disponible);
        listaMascotas.add(mascota);
    }
}
