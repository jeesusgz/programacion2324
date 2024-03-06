package Tema5.Boletin51.Ejercicio3;

import java.time.LocalDate;

public class Alumno extends Persona{
    private static final int MAYORIA_EDAD = 18;
    private LocalDate fechaNacimiento;
    public Alumno(String nombre, LocalDate fecha) {
        super(nombre);
        fechaNacimiento = fecha;
    }

    @Override
    public void enviarMensaje(Persona recepetor, String mensaje) throws MensajeException {
        LocalDate fechaMinima = LocalDate.now().minusYears(MAYORIA_EDAD);
        if (recepetor instanceof  Alumno && fechaNacimiento.isAfter(fechaMinima)){
            throw new MensajeException("Los alumnos menores no pueden enviar mensajes a otros alumnos");
        }
        super.enviarMensaje(recepetor, mensaje);
    }

}
