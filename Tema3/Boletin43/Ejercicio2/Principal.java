package Tema3.Boletin43.Ejercicio2;

public class Principal {
    public static void main(String[] args) {
        Persona p1 = new Persona("mesi");
        Persona p2 = new Persona("serre7");

        try{
            p1.enviarMensaje(p2, "Examen DB", "me quiero sucidar");
            p1.enviarMensaje(p2, "Examen DB", "me quiero sucidar");
            p1.enviarMensaje(p2, "Examen DB", "me quiero sucidar");
            p1.enviarMensaje(p2, "Examen DB", "me quiero sucidar");
        }catch (MensajeException m){
            System.out.println(m.getMessage());
        }
        p1.mostrarBandejaSalida();
        p2.mostrarBandejaEntrada();
    }
}
