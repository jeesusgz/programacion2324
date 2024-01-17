package Tema3.Examen2022;

public class Equipo {

    private static int NUM_MAXIMO_JUGADORES = 2;
    private String pais;
    private String nombreEntrenador;
    private static Jugador[] listaJugadores;

    public Equipo(String pais, String nombreEntrenador) {
        this.pais = pais;
        this.nombreEntrenador = nombreEntrenador;
        this.listaJugadores = new Jugador[10];
    }

    public void addListaJugadores(Jugador nuevoJugador){
        for (int i = 0; i < NUM_MAXIMO_JUGADORES; i++) {
            if (listaJugadores[i] == null){
                this.listaJugadores[i] = nuevoJugador;
                break;
            }
        }
    }

    public void removejugadorLista(Jugador eliminarJugador){
        if (listaJugadores == null){
            System.out.println("No hay ningun jugador en la lista");
        }

        for (int i = 1; i < NUM_MAXIMO_JUGADORES && listaJugadores[i] != null; i++) {
            listaJugadores[i - 1] = listaJugadores[i];
            listaJugadores[i] = null;
        }
    }

    public String getNombreEntrenador() {
        System.out.println("Este es el nombre del entrenador: ");
        return nombreEntrenador;
    }

    public static int obtenerGoles(Jugador[] jugador, Partido[] partidos){
        int golesTotales = 0;

        for (Partido p: partidos) {
            if (Partido.getJugadorLocal().equals(jugador)){
                golesTotales += Partido.getGolesLocal();
            } else if (Partido.getJugadorVisitante().equals(jugador)) {
                golesTotales += Partido.getGolesVisitante();
            }
        }
        return golesTotales;
    }
}
