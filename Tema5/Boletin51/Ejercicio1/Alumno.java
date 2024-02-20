package Tema5.Boletin51.Ejercicio1;

import java.util.Objects;

public class Alumno {
    private String nombre;
    private String dni;

    public Alumno(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Alumno{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", dni='").append(dni).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return Objects.equals(nombre, alumno.nombre) && Objects.equals(dni, alumno.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, dni);
    }
}
