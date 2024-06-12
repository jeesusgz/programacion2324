package Tema5_Repaso.Examen2024.Modelo;

import excepciones.TiendaException;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Tienda {
    private String nombre;
    private Set<Categoria> categorias;

    public Tienda(String nombre) {
        this.nombre = nombre;
        this.categorias = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    /**
     * Añade una nueva categoría. En caso de que exista, lanza una excepción
     * @param nombre
     * @throws TiendaException
     */
    public void addCategoria(String nombre) throws TiendaException {
        if (!categorias.add(new Categoria(nombre))){
            throw new TiendaException("La categoría ya se encuentra");
        }
    }

    /**
     * Añade un producto a una lista de categorías. Se añadirá a aquellas categorías en las que todavía no exista. En
     * aquellas donde ya exista, no se hará nada.
     * @param p
     * @param categorias
     */
    public void addProducto(Producto p, List<Categoria> categorias) throws TiendaException {
        for (Categoria c : categorias){
            if (! this.categorias.contains(c)){
                throw new TiendaException("La categoría no existe");
            }
        }

        for (Categoria categoria : categorias){
            categoria.addProducto(p);
        }
    }

    /**
     * Devuelve un conjunto con aquellas categorías que contienen algún producto sin stock
     * @return
     */
    public Set<Categoria> categoriasConProductosSinStock() {
        return categorias.stream().filter(Categoria::tenerProductoSinStock).collect(Collectors.toSet());
    }

    /**
     * Devuelve un conjunto con las categorías a las que pertenece un producto determinado
     * @param p
     * @return
     */
    public Set<Categoria> categoriasDeProducto(Producto p) {
        return categorias.stream().filter(categoria -> categoria.tenerProductos(p)).collect(Collectors.toSet());
    }

    /**
     * Devuelve un listado con todos los productos de la tienda (sin repetir) ordenados por precio de mayor a menor
     * @return
     */
    public List<Producto> getTodosLosProductosOrdenadosPorPrecio(){
        return categorias.stream().flatMap(categoria -> categoria.getProductos().stream().distinct()
                .sorted((a, b) -> Double.compare(a.getPrecio(), b.getPrecio()))).toList();
    }

    /**
     * Elimina un producto de todas las categorías donde aparezca.
     * @param p
     * @return true si el producto aparecía en alguna categoría
     */
    public boolean eliminaProducto(Producto p){
        for (Categoria categoria : categorias){
            if (!eliminaProducto(p)){
                return false;
            }
        }
        return true;
    }

    /**
     * Devuelve un conjunto con aquellos productos que han sido añadido en el último año (a partir de la fecha actual)
     * @return
     */
    public Set<Producto> productosUltimoAnno(){
        LocalDateTime limite = LocalDateTime.now().minusYears(1);
        return getTodosLosProductosOrdenadosPorPrecio().stream().filter(p -> limite.isBefore(p.getFechaIncorporacion())).collect(Collectors.toSet());
    }
}
