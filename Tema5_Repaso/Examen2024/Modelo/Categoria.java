package Tema5_Repaso.Examen2024.Modelo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Categoria {
    private String nombre;
    private Set<Producto> productos;

    public Categoria(String nombre) {
        this.nombre = nombre;
        this.productos = new HashSet<>();
    }

    public Set<Producto> getProductos() {
        return productos;
    }

    public void addProducto(Producto p){
       productos.add(p);
    }

    public boolean borrarProducto(Producto p){
        return productos.remove(p);
    }

    public boolean tenerProductos(Producto p){
        for (Producto producto : productos){
            if (producto.equals(p)){
                return true;
            }
        }
        return false;
    }

    public boolean tenerProductoSinStock(){
        for (Producto p : productos){
            if (p.getStock() == 0){
                return true;
            }
        }
        return false;
    }

    public boolean elimiarProductos(Producto producto){
        return productos.remove(producto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(nombre, categoria.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
