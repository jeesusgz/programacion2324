package Tema5.Boletin51.Ejercicio3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mensaje {
    private Persona remitente;
    private String textoMensaje;
    private LocalDateTime fecha;

    public Mensaje(Persona remitente, String textoMensaje) {
        this.remitente = remitente;
        this.textoMensaje = textoMensaje;
        fecha = LocalDateTime.now();
    }

    public Persona getRemitente() {
        return remitente;
    }

    public String getTextoMensaje() {
        return textoMensaje;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-YYYY HH:mm");
        StringBuilder mensaje = new StringBuilder("De: ")
                .append(remitente.getNombre())
                .append("Texto: ").append(textoMensaje)
                .append("Fecha y hora: ").append(fecha.format(format));
        return mensaje.toString();
    }
}
