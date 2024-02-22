package Tema4.ExamenHerencias.Model;

import Tema4.ExamenHerencias.Enums.WeatherCondition;
import Tema4.ExamenHerencias.Exceptions.MuerteException;
import Tema4.ExamenHerencias.Exceptions.ValorNoValidoException;
import Tema4.ExamenHerencias.Interfaces.Atacable;
import Tema4.ExamenHerencias.Interfaces.Atacador;

public class PokemonElectrico extends Pokemon implements Atacador, Atacable {
    int resistenciaLluvia;
    public PokemonElectrico(String nombre, int puntosSalud, int nivelAtaque, int nivelDefensa, int resistenciaLluvia) {
        super(nombre, puntosSalud, nivelAtaque, nivelDefensa);
        this.resistenciaLluvia = resistenciaLluvia;
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

    public void atacar(Atacable objetivo, WeatherCondition clima) throws MuerteException {
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
