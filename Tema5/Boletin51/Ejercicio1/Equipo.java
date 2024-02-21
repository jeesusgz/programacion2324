package Tema5.Boletin51.Ejercicio1;

import java.util.HashSet;
import java.util.Set;

public class Equipo<E> {
    private String nombre;
    private Set<E> alumnos;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.alumnos = new HashSet<>();
    }

    public void addAlumno(E alumno) throws AlumnoException{
        if (!alumnos.add(alumno)){
            throw new AlumnoException("El alumno ya existe en este equipo");
        }
    }

    public void removeAlumno(E alumno) throws AlumnoException{
        if (!alumnos.remove(alumno)){
            throw new AlumnoException("El alumno no pertenece al equipo");
        }
    }

    public E perteneceAlEquipo(E alumno){
        if (alumnos.contains(alumno)){
            return alumno;
        }else {
            return null;
        }
    }

    public Set<E> getAlumnos() {
        return alumnos;
    }

    public Equipo<E> unionEquipos(Equipo<E> equipo){
        //equipo.nombre es el nombre del segundo equipo y nombre es el nombre del primer equipo
        Equipo<E> resultadoEquipos = new Equipo<>("Union de: " + nombre + " con " + equipo.nombre);
        resultadoEquipos.alumnos.addAll(alumnos);
        resultadoEquipos.alumnos.addAll(equipo.alumnos);
        return resultadoEquipos;
    }

    public Equipo<E> intersecionEquipos(Equipo<E> equipo){
        Equipo<E> resultadoEquipos = new Equipo<>("Intersección de: " + nombre + " con " + equipo.nombre);
        resultadoEquipos.alumnos.addAll(alumnos);
        resultadoEquipos.alumnos.retainAll(equipo.alumnos);
        return resultadoEquipos;
    }
}
