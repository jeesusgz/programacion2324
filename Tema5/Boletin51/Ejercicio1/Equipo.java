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

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public Equipo unionEquipos(Equipo equipo){
        //equipo.nombre es el nombre del segundo equipo y nombre es el nombre del primer equipo
        Equipo resultadoEquipos = new Equipo("Union de: " + nombre + " con " + equipo.nombre);
        resultadoEquipos.alumnos.addAll(alumnos);
        resultadoEquipos.alumnos.addAll(equipo.alumnos);
        return resultadoEquipos;
    }

    public Equipo intersecionEquipos(Equipo equipo){
        Equipo resultadoEquipos = new Equipo("Intersección de: " + nombre + " con " + equipo.nombre);
        resultadoEquipos.alumnos.addAll(alumnos);
        resultadoEquipos.alumnos.retainAll(equipo.alumnos);
        return resultadoEquipos;
    }
}
