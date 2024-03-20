package Tema5.Examen2023;

import Tema4.DeepSpaceConqueror.JuegoException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Liga {
    private List<Equipo> equipos;
    private String nombre;
    
    public Liga(String nombre) {
        super();
        this.equipos = new ArrayList<>();
        this.nombre = nombre;
    }
    
    public void addEquipo(Equipo e) throws LigaException {
        if (equipos.contains(e)){
            throw new LigaException("El equipo está inscrito");
        }

        if (e.getJugadores().isEmpty()){
            throw new LigaException("El equipo no contiene jugadores");
        }

        equipos.add(e);
    }
    
    public void eliminaEquipo(Equipo e) throws LigaException {
        if (!equipos.remove(e)){
            throw new LigaException("El equipo no está inscrito");
        }
    }

    public void unirEquipos(Equipo e1, Equipo e2) throws LigaException {
        if (!equipos.contains(e1) || !equipos.contains(e2)){
            throw new LigaException("Los dos equipos deben estar inscritos");
        }

        //Unión
        e1.addJugadores(e2.getJugadores());
    }
    
    public List<Jugador> jugadoresEnComun(Equipo e1, Equipo e2) throws LigaException {
        if (!equipos.contains(e1) || !equipos.contains(e2)){
            throw new LigaException("Los dos equipos deben estar inscritos");
        }

        //intersección
        Set<Jugador> jugador = new HashSet<>(e1.getJugadores());
        jugador.retainAll(e2.getJugadores());

        return new ArrayList<>(jugador);
    }
    
    public double mediaEdad() throws LigaException {
       return todosLosJugadores().stream().mapToInt(Jugador::calculaEdad).average().orElseThrow(LigaException::new);
    }
    
    public List<Jugador> jugadoresOrdenadosEdad() {
        //ordenado de mayor a menor para eso primero pongo b y luego a
        return todosLosJugadores().stream().sorted((a, b) -> b.getFechaNacimiento().compareTo(a.getFechaNacimiento()))
                .toList();
    }
    
    public List<Jugador> jugadoresOrdenadosNombre() {
        return todosLosJugadores().stream().sorted((a, b) -> a.getNombre().compareTo(b.getNombre())).toList();
    }
    
    private Set<Jugador> todosLosJugadores() {
        Set<Jugador> todos = new HashSet<>();

        for (Equipo e : equipos){
            todos.addAll(e.getJugadores());
        }

        return todos;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Bienvenidos a " + nombre).append(System.lineSeparator());
        sb.append("Equipos: ").append(System.lineSeparator());
        for (Equipo e: equipos) {
            sb.append(e).append(System.lineSeparator());
        }
        
        return sb.toString();
        
    }
}
