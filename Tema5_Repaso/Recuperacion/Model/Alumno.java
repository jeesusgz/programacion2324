package Tema5_Repaso.Recuperacion.Model;

import exceptions.CursoException;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;


public class Alumno {

    private String nombre;
    private String dni;
    private LocalDate fechaNacimiento;
    private boolean repetidor;
    private Set<LocalDate> faltasAsistencia;
    private Map<Materia, Double> materiasMatriculadas;

    public Alumno(String nombre, String dni, LocalDate fechaNacimiento, boolean repetidor) throws CursoException {
        setNombre(nombre);
        setDni(dni);
        setFechaNacimiento(fechaNacimiento);
        this.repetidor = repetidor;
        this.faltasAsistencia = new HashSet<>();
        this.materiasMatriculadas = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public boolean isRepetidor() {
        return repetidor;
    }

    public Set<LocalDate> getFaltasAsistencia() {
        return faltasAsistencia;
    }

    public Map<Materia, Double> getMateriasMatriculadas() {
        return materiasMatriculadas;
    }

    private void setFechaNacimiento(LocalDate fechaNacimiento) throws CursoException {
        LocalDate limite = LocalDate.of(2000, 1, 1);
        LocalDate now = LocalDate.now();
        if (fechaNacimiento.isBefore(limite) || fechaNacimiento.isAfter(now)){
            throw new CursoException("Fecha inválida");
        }
        this.fechaNacimiento = fechaNacimiento;
    }

    public void matricularMateria(Materia materia) throws CursoException {
        if (materiasMatriculadas.containsKey(materia)){
            throw new CursoException("No está matriculado a esa materia");
        }
        materiasMatriculadas.put(materia, null);
    }

    public void setNota(Materia materia, double calificacion) throws CursoException {
        if (!materiasMatriculadas.containsKey(materia)) {
            throw new CursoException("No está matriculado en esta materia");
        }

        if (calificacion < 0 || calificacion > 10) {
            throw new CursoException("La nota es inválida");
        }
    }

    public void agregarFalta(LocalDate fecha) throws CursoException {
        LocalDate limite = LocalDate.of(2023, 9, 15);
        LocalDate now = LocalDate.now();

        if (fecha.isBefore(limite) || fecha.isAfter(now)){
            throw new CursoException("La fecha es inválida");
        }

        faltasAsistencia.add(fecha);
    }

    public void setNombre(String nombre) throws CursoException {
        if (nombre.isEmpty()){
            throw new CursoException("El alumno no tiene nombre");
        }
        this.nombre = nombre;
    }

    public void setDni(String dni) throws CursoException {
        if (dni.isEmpty()){
            throw new CursoException("El DNI está vacío");
        }
        this.dni = dni;
    }

    public int getEdad() {
        // Devuelve la edad en años (con decimales) a partir de la fecha de nacimiento
        Period periodo = Period.between(fechaNacimiento, LocalDate.now());
        return periodo.getYears();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return Objects.equals(dni, alumno.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }
}
