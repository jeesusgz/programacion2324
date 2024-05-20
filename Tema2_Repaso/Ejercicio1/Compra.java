package Tema2_Repaso.Ejercicio1;

import java.time.LocalDateTime;

public class Compra {
    private int id;
    private Mascota mascota;
    private Cliente cliente;
    private LocalDateTime fecha;
    private LocalDateTime fechaDevolucion;

    private static int contCompra = 1;

    public Compra(Mascota mascota, Cliente cliente) {
        this.mascota = mascota;
        this.cliente = cliente;
        this.fecha = LocalDateTime.now();
        this.id = contCompra++;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public LocalDateTime getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void marcarDevolucion(){
       this.fechaDevolucion = LocalDateTime.now();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Compra{");
        sb.append("id=").append(id);
        sb.append(", mascota=").append(mascota);
        sb.append(", cliente=").append(cliente);
        sb.append(", fecha=").append(fecha);
        sb.append('}');
        return sb.toString();
    }
}
