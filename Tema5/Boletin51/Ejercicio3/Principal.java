package Tema5.Boletin51.Ejercicio3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        Persona per1 = new Profesor("pepe");
        Persona per2 = new Alumno("carlos", LocalDate.of(2012, 12, 12));
        Persona per3 = new Profesor("pepe");

        List<Persona> personas = new ArrayList<>();
        personas.add(per1);
        personas.add(per2);
        personas.add(per3);

        try {
            personas.get(0).enviarMensaje(personas.get(1), "Hola es un mensaje de prueba");
            Thread.sleep(1000);
            personas.get(1).enviarMensaje(personas.get(0), "Hola es un mensaje de prueba2");
            Thread.sleep(1000);
            personas.get(0).enviarMensaje(personas.get(1), "Hola es un mensaje de prueba3");
            Thread.sleep(1000);
            personas.get(1).enviarMensaje(personas.get(0), "Hola es un mensaje de prueba4");
            Thread.sleep(1000);
        } catch (MensajeException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Sin ordenar: ");
        System.out.println(personas.get(0).leerMensajes());
        System.out.println("tras ordenar: ");
        System.out.println(personas.get(0).leerMensajesOrdenados());

        try {
            personas.get(0).borrarMensaje(-3);
        } catch (MensajeException e) {
            System.out.println(e.getMessage());
        }

        try {
            personas.get(0).filtarMensajePorFrase("prueba3");
        } catch (MensajeException e) {
            System.out.println(e.getMessage());
        }

        try {
            personas.get(0).filtarMensajePorFrase("hola");
        } catch (MensajeException e) {
            System.out.println(e.getMessage());
        }
    }
}
