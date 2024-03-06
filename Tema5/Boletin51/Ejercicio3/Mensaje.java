package Tema5.Boletin51.Ejercicio3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mensaje {
    private Persona remitente;
    private String texto;
    private LocalDateTime fecha;

    public Mensaje(Persona remitente, String texto) {
        this.remitente = remitente;
        this.texto = texto;
        fecha = LocalDateTime.now();
    }

    public Persona getRemitente() {
        return remitente;
    }

    public String getTexto() {
        return texto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("d");
        StringBuilder mensaje = new StringBuilder("De: ")
                .append(remitente.getNombre())
                .append(" Texto: ").append(texto)
                .append(" Fecha y hora").append(fecha.format(format));
        return mensaje.toString();
    }
    public int compareTo(Mensaje mensaje){
        return fecha.compareTo(mensaje.fecha);
    }
}
