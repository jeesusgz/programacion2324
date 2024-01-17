package Tema3.Examen2022;

public class Partido {
    private static Jugador jugadorLocal;
    private static Jugador jugadorVisitante;
    private static Equipo equipoLocal;
    private static Equipo equipoVisitante;

    private static int golesLocal;
    private static int golesVisitante;

    public Partido(Jugador jugadorLocal, Jugador jugadorVisitante, Equipo equipoLocal, Equipo equipoVisitante, int golesLocal, int golesVisitante) {
        this.jugadorLocal = jugadorLocal;
        this.jugadorVisitante = jugadorVisitante;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
    }

    public static Jugador getJugadorLocal() {
        return jugadorLocal;
    }

    public static Jugador getJugadorVisitante() {
        return jugadorVisitante;
    }

    public static Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public static Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public static int getGolesLocal() {
        return golesLocal;
    }

    public static int getGolesVisitante() {
        return golesVisitante;
    }
}
