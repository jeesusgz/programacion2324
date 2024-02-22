package Tema4.ExamenHerencias.Model;

import Tema4.ExamenHerencias.Enums.WeatherCondition;
import Tema4.ExamenHerencias.Exceptions.MuerteException;
import Tema4.ExamenHerencias.Exceptions.ValorNoValidoException;
import Tema4.ExamenHerencias.Interfaces.Atacable;
import Tema4.ExamenHerencias.Interfaces.Atacador;


public class PokemonAgua extends Pokemon implements Atacable, Atacador {
    int curar;

    public PokemonAgua(String nombre, int puntosSalud, int nivelAtaque, int nivelDefensa, int curar) {
        super(nombre, puntosSalud, nivelAtaque, nivelDefensa);

        this.curar = curar;
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
