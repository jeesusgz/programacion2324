package Tema3.Examen2022;

import javax.sound.midi.Soundbank;

public class Jugador {
    private String nombre;
    private int edad;
    private int numGoles;
    private Jugador[] listaGoles;
    private Jugador jugadorLocal;
    private Jugador jugadorVisitante;

    public Jugador(String nombre, int edad, int numGoles) {
        this.nombre = nombre;
        this.edad = edad;
        this.numGoles = numGoles;
    }

    public void addGolJugador(Jugador numGolesJugador){
        for (int i = 0; i < listaGoles.length; i++) {
            if (listaGoles[i] == null){
                this.listaGoles[i] = numGolesJugador;
                break;
            }
        }
    }

    public int getNumGoles() {
        return numGoles;
    }

    public Jugador getJugadorLocal() {
        return jugadorLocal;
    }

    public Jugador getJugadorVisitante() {
        return jugadorVisitante;
    }

    public static void obtenerGoles(Jugador[] jugador, Partido[] partidos){
        int golesTotales = 0;

        for (Partido p: partidos) {
            if (Partido.getJugadorLocal().equals(jugador)){
                golesTotales += Partido.getGolesLocal();
            } else if (Partido.getJugadorVisitante().equals(jugador)) {
                golesTotales += Partido.getGolesVisitante();
            }
        }
        System.out.println("Estos son los goles totales: " + golesTotales);
    }
}
