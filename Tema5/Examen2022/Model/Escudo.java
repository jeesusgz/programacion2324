package Tema5.Examen2022.Model;

public class Escudo extends Cromo{
    private String nombre;
    private int yearFundacion;
    private int numJugadores;

    public Escudo(int id, String nombre, int yearfundacion, int numJugadores) {
        super(id);
        this.nombre = nombre;
        this.yearFundacion = yearfundacion;
        this.numJugadores = numJugadores;
    }

    public String getNombre() {
        return nombre;
    }

    public int getYearFundacion() {
        return yearFundacion;
    }

    public int getNumJugadores() {
        return numJugadores;
    }

    @Override
    public String getEquipo() {
        return nombre;
    }
}
