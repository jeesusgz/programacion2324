package Tema5_Repaso.Examen2024.Modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Producto {
    private String marca;
    private String modelo;
    private String descripcion;
    private double precio;
    private LocalDateTime fechaIncorporacion;
    private int stock;

    public Producto(String marca, String modelo, String descripcion, double precio, int stock) {
        this.marca = marca;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaIncorporacion = LocalDateTime.now();
        setStock(stock);
    }

    public int getStock() {
        return stock;
    }

    public double getPrecio() {
        return precio;
    }

    public LocalDateTime getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public void setStock(int stock) {
        if (stock < 0){
            this.stock = 0;
        }else {
            this.stock = stock;
        }
    }


}
