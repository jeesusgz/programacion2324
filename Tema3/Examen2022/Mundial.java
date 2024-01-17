package Tema3.Examen2022;

public class Mundial {
    private static int NUM_MAX_EQUIPOS = 4;
    private String nombre;
    private Equipo[] listaEquipos;
    private Jugador[] jugadores;

    public Mundial(String nombre, Equipo[] listaEquipos) {
        this.nombre = nombre;
        this.listaEquipos = new Equipo[NUM_MAX_EQUIPOS];
    }

    public void addEquipo(Equipo nuevoEquipo){
        for (int i = 0; i < NUM_MAX_EQUIPOS; i++) {
            if (listaEquipos[i] == null){
                this.listaEquipos[i] = nuevoEquipo;
                break;
            }
        }
    }

    public void removeEquipoLista(){
        if (listaEquipos[0] == null){
            System.out.println("No hay ningun equipo en la lista");
        }
        boolean salir = false;

        for (int i = 0; i < NUM_MAX_EQUIPOS && !salir; i++) {
            listaEquipos[i - 1] = listaEquipos[i];
            listaEquipos[i] = null;

            if (i < NUM_MAX_EQUIPOS - 1 && listaEquipos[i + 1] == null){
                salir = true;
            }
        }
    }

    public static void obtenerGolesJugador(Jugador[] jugador, Partido[] partido){
        int golesTotales = 0;

        for (Partido p: partido) {
            if (Partido.getJugadorLocal().equals(jugador)){
                golesTotales += Partido.getGolesLocal();
            } else if (Partido.getJugadorVisitante().equals(jugador)) {
                golesTotales += Partido.getGolesVisitante();
            }
        }
        System.out.println("Estos son los goles totales: " + golesTotales);
    }

    public static void golesTotalesEquipo(Equipo[] equipo, Partido[] partidos){
        int golesTotales = 0;

        for (Partido p: partidos) {
            if (Partido.getEquipoLocal().equals(equipo)){
                golesTotales += Partido.getGolesLocal();
            } else if (Partido.getEquipoVisitante().equals(equipo)) {
                golesTotales += Partido.getGolesVisitante();
            }
        }
        System.out.println("Estos son los goles totales: " + golesTotales);
    }

    public static void obtenerEquipoMasGoles(Partido[] partidos, Jugador[] jugadores, Equipo[] equipo){
        int maxGoles = 0;

        for (Equipo e : equipo) {
            int totalGolesEquipo = Equipo.obtenerGoles(jugadores, partidos);

            if (totalGolesEquipo > maxGoles){
                maxGoles = totalGolesEquipo;
            }
        }
    }



    public static void menuMundial(){
        System.out.println("Introduce una opcion: ");
        System.out.println("1. Crear un nuevo equipo");
        System.out.println("2. Añadir un nuevo jugador a un equipo existente");
        System.out.println("3. Ver el número total de goles marcados por un equipo existente");
        System.out.println("4. Ver el número total de goles marcados por un jugador existente");
        System.out.println("5. Ver el equipo con más goles marcados en el mundia");
        System.out.println("6. Ver el jugador con más goles marcados en el mundial");
    }
}
