package Tema5.Boletin51.Ejercicio1;

import java.util.HashSet;
import java.util.Set;

public class Equipo {
    private String nombre;
    private Set<Alumno> alumnos;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.alumnos = new HashSet<>();
    }

    public void addAlumno(Alumno alumno) throws AlumnoException{
        if (!alumnos.add(alumno)){
            throw new AlumnoException("El alumno ya existe en este equipo");
        }
    }

    public void removeAlumno(Alumno alumno) throws AlumnoException{
        if (!alumnos.remove(alumno)){
            throw new AlumnoException("El alumno no pertenece al equipo");
        }
    }

    public Alumno perteneceAlEquipo(Alumno alumno){
        if (alumnos.contains(alumno)){
            return alumno;
        }else {
            return null;
        }
    }
}
