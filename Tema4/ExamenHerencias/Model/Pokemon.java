package Tema4.ExamenHerencias.Model;

import Tema4.ExamenHerencias.Enums.WeatherCondition;
import Tema4.ExamenHerencias.Exceptions.MuerteException;
import Tema4.ExamenHerencias.Exceptions.RoundStartException;
import Tema4.ExamenHerencias.Exceptions.ValorNoValidoException;
import Tema4.ExamenHerencias.Interfaces.Atacable;
import Tema4.ExamenHerencias.Interfaces.Atacador;
import Tema5.Boletin51.Ejercicio3.MensajeException;

import java.util.Random;

public  class Pokemon implements Atacador, Atacable {
    String nombre;
    int puntosSalud;
    int nivelAtaque;
    int nivelDefensa;

    public Pokemon(String nombre, int puntosSalud, int nivelAtaque, int nivelDefensa) {
        this.nombre = nombre;
        this.puntosSalud = puntosSalud;
        this.nivelAtaque = nivelAtaque;
        this.nivelDefensa = nivelDefensa;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntosSalud() {
        return puntosSalud;
    }

    public boolean estaVivo() {
        if (puntosSalud > 0){
            return true;
        }else {
            return false;
        }
    }

    public void roundStart(WeatherCondition clima) throws RoundStartException {
        if (clima == null){
            throw new RoundStartException("Tiene que haber un clima");
        }


    }

    @Override
    public void serAtacado() throws ValorNoValidoException, MuerteException{
        if (nivelAtaque < 0){
            throw new ValorNoValidoException("El daño no puede ser negativo");
        }

        puntosSalud -= nivelAtaque;

        if (puntosSalud <= 0){
            throw new MuerteException("El pokemon " + nombre + " ha sido derrotado");
        }
    }

    @Override
    public void atacar(Atacable objetivo, WeatherCondition clima) throws MuerteException{
        if (puntosSalud <= 0){
            throw new MuerteException("El pokemon " + nombre + " está muerto");
        }

        try {
            objetivo.serAtacado();
        } catch (ValorNoValidoException e) {
            throw new RuntimeException(e);
        }

    }
}
