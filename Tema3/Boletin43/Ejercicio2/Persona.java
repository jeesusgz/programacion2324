package Tema3.Boletin43.Ejercicio2;

import java.util.Arrays;

public class Persona {
    private static final int  TAMANO_BANDEJA = 5;
    private String nombre;
    private Mensaje[] mensajesRecibidos;
    private Mensaje[] mensajesEnviados;

    public Persona(String nombre) {
        this.nombre = nombre;
        this.mensajesRecibidos = new Mensaje[TAMANO_BANDEJA];
        this.mensajesEnviados = new Mensaje[TAMANO_BANDEJA];
    }

    public void enviarMensaje(Persona destinatario, String asunto, String cuerpo) throws MensajeException{
        if (destinatario == null) {
            throw new MensajeException("Destinatario erróneo");
        }

        if (asunto == null || asunto.length() == 0){
            throw new MensajeException("El asunto está vacío");
        }

        if (cuerpo == null || cuerpo.length() == 0){
            throw new MensajeException("El cuerpo está vacío");
        }

        if (mensajesEnviados[TAMANO_BANDEJA - 1] != null){
            throw new MensajeException("La bandeja de salida se encuentra llena");
        }

        if (destinatario.mensajesEnviados[TAMANO_BANDEJA - 1] != null){
            throw new MensajeException("La bandeja de entrada se encuentra llena");
        }

        Mensaje m = new Mensaje(asunto, cuerpo, this, destinatario);

        //Bandeja de enviados
        boolean posvacia = false;
        for (int i = 0; i < TAMANO_BANDEJA && !posvacia; i++) {
            if (mensajesEnviados[i] == null){
                mensajesEnviados[i] = m;
                posvacia = true;
            }
        }

        //bandeja de remitente
        posvacia = false;
        for (int i = 0; i < TAMANO_BANDEJA && !posvacia; i++) {
            if (destinatario.mensajesEnviados[i] == null){
                destinatario.mensajesEnviados[i] = m;
                posvacia = true;
            }
        }
    }

    public void mostrarBandejaEntrada(){
        if (mensajesRecibidos[0] == null){
            System.out.println("Su bandeja de entrada está vacía");
        }else {
            for (int i = 0; i < TAMANO_BANDEJA && mensajesRecibidos[i] != null; i++) {
                System.out.println(mensajesRecibidos[i]);
            }
        }
    }

    public void mostrarBandejaSalida(){
        if (mensajesEnviados[0] == null){
            System.out.println("Su bandeja de salida está vacía");
        }else {
            for (int i = 0; i < TAMANO_BANDEJA && mensajesEnviados[i] != null; i++) {
                System.out.println(mensajesEnviados[i]);
            }
        }
    }

    public void borrarMensajeEnviadoMasAntiguo() throws MensajeException{
        if (mensajesEnviados[0] == null){
            throw new MensajeException("La bandeja de salida está vacía");
        }

        boolean salir = false;
        for (int i = 1; i < TAMANO_BANDEJA && !salir; i++) {
            mensajesEnviados[i - 1] = mensajesEnviados[i];
            mensajesEnviados[i] = null;

            if (i < TAMANO_BANDEJA - 1 && mensajesEnviados[i + 1] == null){
                salir = true;
            }
        }
    }

    public void borrarMensajeRecibidoMasAntiguo() throws MensajeException{
        if (mensajesEnviados[0] == null){
            throw new MensajeException("La bandeja de entrada está vacía");
        }

        boolean salir = false;
        for (int i = 1; i < TAMANO_BANDEJA && !salir; i++) {
            mensajesEnviados[i - 1] = mensajesEnviados[i];
            mensajesEnviados[i] = null;

            if (i < TAMANO_BANDEJA - 1 && mensajesEnviados[i + 1] == null){
                salir = true;
            }
        }
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", mensajesRecibidos=" + Arrays.toString(mensajesRecibidos) +
                ", mensajesEnviados=" + Arrays.toString(mensajesEnviados) +
                '}';
    }
}
