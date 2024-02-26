package Tema4.ExamenHerenciasCorregido.Model;

import Tema4.ExamenHerenciasCorregido.Enums.WeatherCondition;
import Tema4.ExamenHerenciasCorregido.Exceptions.RoundStartException;
import Tema4.ExamenHerenciasCorregido.Exceptions.ValorNoValidoException;
import Tema4.ExamenHerenciasCorregido.Interfaces.Atacador;

public abstract class Pokemon implements Atacador {

    public final static int MAX_SALUD = 100;
    public final static int MIN_ATAQUE = 5;
    public final static int MAX_ATAQUE = 15;
    public final static int MIN_DEFENSA = 5;
    public final static int MAX_DEFENSA = 25;
    private String nombre;
    private int puntosSalud;
    private int ataque;
    private int defensa;

    public Pokemon(String nombre, int puntosSalud, int ataque, int defensa) throws ValorNoValidoException {
        this.nombre = nombre;
        this.setPuntosSalud(puntosSalud);
        this.setAtaque(ataque);
        this.setDefensa(defensa);
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntosSalud() {
        return puntosSalud;
    }

    public void setPuntosSalud(int puntosSalud) {
        if (puntosSalud < 0){
            puntosSalud = 0;
        }else if (puntosSalud > MAX_SALUD){
            puntosSalud = MAX_SALUD;
        }
        this.puntosSalud = puntosSalud;
    }


    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setAtaque(int ataque) throws  ValorNoValidoException{
        if (ataque < MIN_ATAQUE || ataque > MAX_ATAQUE){
            throw new ValorNoValidoException("El valor de ataque debe estar entre " + MIN_ATAQUE + " y " + MAX_ATAQUE);
        }
        this.ataque = ataque;
    }

    public void setDefensa(int defensa) throws ValorNoValidoException{
        if (ataque < MIN_DEFENSA || ataque > MAX_DEFENSA){
            throw new ValorNoValidoException("El valor de ataque debe estar entre " + MIN_DEFENSA + " y " + MAX_DEFENSA);
        }
        this.defensa = defensa;
    }

    public abstract void roundStart(WeatherCondition clima) throws RoundStartException;

    public boolean estaVivo(){
        return puntosSalud > 0;
    }

}
