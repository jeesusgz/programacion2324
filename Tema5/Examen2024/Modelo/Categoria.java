package Tema5.Examen2024.Modelo;

import java.util.HashSet;
import java.util.Set;

public class Categoria {
    private String nombre;
    private Set<Producto> productos;

    public Categoria(String nombre) {
        this.nombre = nombre;
        productos = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public Set<Producto> getProductos() {
        return productos;
    }
}
