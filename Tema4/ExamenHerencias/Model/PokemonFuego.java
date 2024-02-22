package Tema4.ExamenHerencias.Model;

import Tema4.ExamenHerencias.Enums.WeatherCondition;
import Tema4.ExamenHerencias.Exceptions.MuerteException;
import Tema4.ExamenHerencias.Exceptions.ValorNoValidoException;
import Tema4.ExamenHerencias.Interfaces.Atacable;
import Tema4.ExamenHerencias.Interfaces.Atacador;

public class PokemonFuego extends Pokemon implements Atacador, Atacable {
    int resistenciaAgua;

    public PokemonFuego(String nombre, int puntosSalud, int nivelAtaque, int nivelDefensa, int resistenciaAgua) {
        super(nombre, puntosSalud, nivelAtaque, nivelDefensa);
        this.resistenciaAgua = resistenciaAgua;
    }

    @Override
    public void serAtacado() {

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
