package Tema5.Examen2024.Modelo;

import java.time.LocalDate;
import java.util.Objects;

public class Producto {
    private String marca;
    private String modelo;
    private String descripcion;
    private double precio;
    private LocalDate fechaIncorporacion;
    private int stock;

    public Producto(String marca, String modelo, String descripcion, double precio, LocalDate fechaIncorporacion, int stock) {
        this.marca = marca;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaIncorporacion = fechaIncorporacion;
        this.stock = stock;
    }



    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public LocalDate getFechaIncorporacion() {
        return fechaIncorporacion;
    }
}
