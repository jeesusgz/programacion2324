package Tema5.Boletin51.Ejercicio1;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Principal {

    public static void main(String[] args) {
        Equipo equipo1 = new Equipo("beti");
        Equipo equipo2 = new Equipo("barsa");

        for (int i = 0; i < 10; i++) {
            try {
                equipo1.addAlumno(generateAlumno());
            } catch (AlumnoException e) {
                System.out.println("Alumno repetido");
            }

            try {
                equipo2.addAlumno(generateAlumno());
            } catch (AlumnoException e) {
                System.out.println("Alumno repetido");
            }
        }
        System.out.println();
        System.out.println("Equipo 1");
        mostrarConjuntoPersonas(equipo1.getAlumnos());
        System.out.println();
        System.out.println("Equipo 2");
        mostrarConjuntoPersonas(equipo2.getAlumnos());

        System.out.println();
        System.out.println("Equipo unido");
        Equipo equipoU = equipo1.unionEquipos(equipo2);
        mostrarConjuntoPersonas(equipoU.getAlumnos());

        System.out.println();
        System.out.println("Intersección de equipos");
        Equipo equipoI = equipo1.intersecionEquipos(equipo2);
        mostrarConjuntoPersonas(equipoI.getAlumnos());
    }

    public static void mostrarConjuntoPersonas(Set<Alumno> alumnos){
        //elemento necesario para recorrer el conjunto de alumnos
        Iterator<Alumno> it = alumnos.iterator();

        while (it.hasNext()){
            Alumno alumno = it.next();
            System.out.println(alumno);
        }
    }

    public static Alumno generateAlumno(){
        String nombre;
        Random r = new Random();
        nombre = "" + r.nextInt(14);

        return new Alumno(nombre, nombre);
    }
}
