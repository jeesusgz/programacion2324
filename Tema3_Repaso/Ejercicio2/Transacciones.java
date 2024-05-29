package Tema3_Repaso.Ejercicio2;

import java.time.LocalDateTime;

public class Transacciones {
    private int numeroUnidades;
    private double precio;
    private ProductosAgricolas productosAgricolas;
    private LocalDateTime fecha_transaccion;

    public Transacciones(ProductosAgricolas productosAgricolas, int numeroUnidades) {
        this.productosAgricolas = productosAgricolas;
        this.numeroUnidades = numeroUnidades;
        this.precio = productosAgricolas.getPrecio();
        this.fecha_transaccion = LocalDateTime.now();
    }

    public double getTotalTransaccion(){
        return numeroUnidades * precio;
    }
}
