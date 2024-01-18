package Tema3.Examen2022;

import java.util.Scanner;

public class PrincipalMundial {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Jugador[] jugadores = new Jugador[100];
        Partido[] partidos = new Partido[20];
        Equipo[] equipos = new Equipo[5];



        int opcion;

        do {
            Mundial.menuMundial();
            opcion = Integer.parseInt(sc.nextLine());
        }while (opcion > 6);

        switch (opcion){
            case 1:
                crearNuevoEquipo();
                break;
            case 2:
                addJugador();
                break;
            case 3:
                Mundial.golesTotalesEquipo(equipos, partidos);
                break;
            case 4:
                Mundial.obtenerGolesJugador(jugadores, partidos);
            case 5:
                Mundial.obtenerEquipoMasGoles(partidos, jugadores, equipos);
                break;
            case 6:
                break;

        }
    }

    public static void crearNuevoEquipo(){
        System.out.println("Cual es tu pais Representante: ");
        String paisRepresentante = sc.nextLine();

        System.out.println("¿Cuál es el nombre de tu entrenador de equipo: ?");
        String nombreEntrenador = sc.nextLine();

        Equipo nuevoEquipo = new Equipo(paisRepresentante, nombreEntrenador);
        System.out.println("Has creado un nuevo equipo");
    }

    public static void addJugador(){
        Equipo equipo = null;

        System.out.println("Cual es el nombre del jugador: ");
        String nombreJugador = sc.nextLine();

        System.out.println("Cual es la edad del jugador: ");
        int edadJugador = Integer.parseInt(sc.nextLine());

        System.out.println("Cuantos goles ha marcado este jugador: ");
        int numGoles =Integer.parseInt(sc.nextLine());

        Jugador nuevoJugador = new Jugador(nombreJugador, edadJugador, numGoles);

        equipo.addListaJugadores(nuevoJugador);
        System.out.println("Has añadido un jugador a tu equipo");
    }

    public void menuMundial(){
        System.out.println("Introduce una opcion: ");
        System.out.println("1. Crear un nuevo equipo");
        System.out.println("2. Añadir un nuevo jugador a un equipo existente");
        System.out.println("3. Ver el número total de goles marcados por un equipo existente");
        System.out.println("4. Ver el número total de goles marcados por un jugador existente");
        System.out.println("5. Ver el equipo con más goles marcados en el mundia");
        System.out.println("6. Ver el jugador con más goles marcados en el mundial");
    }
}
