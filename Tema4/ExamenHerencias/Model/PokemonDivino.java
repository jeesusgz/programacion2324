package Tema4.ExamenHerencias.Model;

import Tema4.ExamenHerencias.Interfaces.Atacable;
import Tema4.ExamenHerencias.Interfaces.Atacador;

public class PokemonDivino extends Pokemon implements Atacador {
    public PokemonDivino(String nombre, int puntosSalud, int nivelAtaque, int nivelDefensa) {
        super(nombre, puntosSalud, nivelAtaque, nivelDefensa);
    }

    @Override
    public void atacar(Atacable objetivo) {

    }
}
