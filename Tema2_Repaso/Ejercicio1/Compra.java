package Tema2_Repaso.Ejercicio1;

import java.time.LocalDateTime;

public class Compra {
    private int id;
    private Mascota mascota;
    private Cliente cliente;
    private LocalDateTime fecha;

    private static int contCompra = 1;

    public Compra(Mascota mascota, Cliente cliente) {
        this.mascota = mascota;
        this.cliente = cliente;
        this.fecha = LocalDateTime.now();
        this.id = contCompra++;
    }
}
