package Tema5_Repaso.Recuperacion.Model;

import exceptions.CursoException;
import java.time.LocalDate;
import java.util.*;

public class Curso {
    private String nombre;
    private Set<Alumno> alumnos;
    private Set<Materia> materias;

    public Curso(String nombre) throws CursoException {
        setNombre(nombre);
        this.alumnos = new HashSet<>();
        this.materias = new HashSet<>();
    }

    public void agregarAlumno(Alumno alumno) {
        this.alumnos.add(alumno);
    }

    public void agregarMateria(Materia materia) {
        this.materias.add(materia);
    }

    public Set<Alumno> getAlumnos() {
        return this.alumnos;
    }

    public Set<Materia> getMaterias() {
        return this.materias;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) throws CursoException {
        if (nombre.isEmpty()){
            throw new CursoException("El alumno no tiene nombre");
        }
        this.nombre = nombre;
    }

    public void matricularAlumno(Alumno alumno, Materia materiaOptativa) throws CursoException {
        for (Materia m : materias){

            if (m.isObligatoria()){
                alumno.matricularMateria(m);
            }
        }
        alumno.matricularMateria(materiaOptativa);
    }


    public void asignarNota(Alumno alumno, Materia materia, double calificacion) throws CursoException {

    }

    public Map<Alumno, Integer> getAlumnosConNumeroSuspensos() {

    }

    public double mediaEdad() {

    }


    public double notaMaximaRepetidores(Materia materia) {

    }

    public void eliminarAlumno(Alumno alumno) {
        this.alumnos.remove(alumno);
    }

    public void addFaltaDeAsistencia(Alumno alumno, LocalDate fecha) throws CursoException {
        alumno.agregarFalta(fecha);
    }

    public Map<Alumno, Integer> getFaltasDeAsistenciaUltimos15Dias() {

    }
}
