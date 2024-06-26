package Tema5.Examen2022.Model;

import Tema5.Examen2023.Equipo;

public class Jugador extends Cromo{
    private String nombre;
    private String equipo;
    private int altura;

    public Jugador(int id, String nombre, String equipo, int altura) {
        super(id);
        this.nombre = nombre;
        this.equipo = equipo;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAltura() {
        return altura;
    }

    @Override
    public String getEquipo() {
        return equipo;
    }
}
