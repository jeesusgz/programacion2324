package Tema3_Repaso.Ejercicio2;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProductosAgricolas {
    private String nombreProducto;
    private Productos tipoProducto;
    private int cantDisponible;
    private double precio;
    private LocalDateTime fecha;

    private List<String> listaRegistroPrecio;
    private List<String> listaRegistroCantidad;

    private boolean disponible;

    public ProductosAgricolas(String nombreProducto, Productos tipoProducto, int cantDisponible, double precio) {
        this.nombreProducto = nombreProducto;
        this.tipoProducto = tipoProducto;
        this.cantDisponible = cantDisponible;
        this.precio = precio;
        this.listaRegistroCantidad = new ArrayList<>();
        this.listaRegistroPrecio = new ArrayList<>();
        this.fecha = LocalDateTime.now();
    }

    public int getCantDisponible() {
        return cantDisponible;
    }

    public boolean isDisponible() {
        return cantDisponible > 0;
    }

    public void setCantDisponible(int cantDisponible) {
        this.cantDisponible = cantDisponible;
    }

    public double getPrecio() {
        return precio;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }


    public String getNombreProducto() {
        return nombreProducto;
    }

    public void registrarPrecio() {
        listaRegistroPrecio.add("El precio actual del producto es: " + getPrecio() + " ,La fecha actual es: " + getFecha());
    }

    public void registrarCantidadDispoble() {
        listaRegistroCantidad.add("La cantidad disponible es: " + getCantDisponible() + " ,La fecha actual es: " + getFecha());
    }

    public void repornerUnidades(int cantDisponible) throws ProductosAgricolasException {
        if (cantDisponible < 0){
            throw new ProductosAgricolasException("Error!, valor no valido");
        }
        this.cantDisponible += cantDisponible;
    }

    public void comprarUnidades(int comprarUnidades) throws ProductosAgricolasException {
        if (comprarUnidades < 0){
            throw new ProductosAgricolasException("Error!, valor no valido");
        }
        if (comprarUnidades > cantDisponible){
            throw new ProductosAgricolasException("No hay suficiente stock");
        }
        this.cantDisponible -= comprarUnidades;
    }


    @Override
    public String toString () {
        return "ProductosAgricolas{" +
                "nombreProducto='" + nombreProducto + '\'' +
                ", tipoProducto=" + tipoProducto +
                ", cantDisponible=" + cantDisponible +
                ", precio=" + precio +
                ", disponible=" + disponible +
                '}';
    }
}
