package Tema5.Boletin51.Ejercicio1;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Principal {

    public static void main(String[] args) {
        Equipo<Alumno> equipo1 = new Equipo<>("beti");
        Equipo<Alumno> equipo2 = new Equipo<>("barsa");
        Equipo<Integer> equipo3 = new Equipo<>("San Roque De Lepe");

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

            try {
                equipo3.addAlumno(generateEnteros());
            } catch (AlumnoException e) {
                System.out.println("Entero repetido");
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
        Equipo<Alumno> equipoU = equipo1.unionEquipos(equipo2);
        mostrarConjuntoPersonas(equipoU.getAlumnos());

        System.out.println();
        System.out.println("Intersección de equipos");
        Equipo<Alumno> equipoI = equipo1.intersecionEquipos(equipo2);
        mostrarConjuntoPersonas(equipoI.getAlumnos());
        System.out.println();
        System.out.println("Equipo 3");
        mostrarConjuntoPersonas(equipo3.getAlumnos());
    }

    public static<E> void mostrarConjuntoPersonas(Set<E> alumnos){
        //elemento necesario para recorrer el conjunto de alumnos
        Iterator<E> it = alumnos.iterator();

        while (it.hasNext()){
            E alumno = it.next();
            System.out.println(alumno);
        }
    }

    public static Integer generateEnteros(){
        Random r = new Random();
        return r.nextInt(10);
    }

    public static Alumno generateAlumno(){
        String nombre;
        Random r = new Random();
        nombre = "" + r.nextInt(14);

        return new Alumno(nombre, nombre);
    }
}
