package Tema4.Examen2122;

import java.time.LocalDateTime;

public class Fichero {
    private String name;
    private long size;
    private LocalDateTime date;

    public Fichero(String name, long size) {
        setSize(size);
        this.name = name;
        this.date = LocalDateTime.now();
    }

    /**
     * TODO capturar excepción
     * @param size
     * @throws IllegalArgumentException
     */
    private void setSize(long size) {
        if (size < 1) {
            throw new IllegalArgumentException("El tamaño del archivo no puede ser negativo");
        }
        this.size = size;
    }


}
