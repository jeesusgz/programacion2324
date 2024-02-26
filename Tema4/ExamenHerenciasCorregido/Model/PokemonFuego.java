package Tema4.ExamenHerenciasCorregido.Model;

import Tema4.ExamenHerenciasCorregido.Enums.WeatherCondition;
import Tema4.ExamenHerenciasCorregido.Exceptions.MuerteException;
import Tema4.ExamenHerenciasCorregido.Exceptions.RoundStartException;
import Tema4.ExamenHerenciasCorregido.Exceptions.ValorNoValidoException;
import Tema4.ExamenHerenciasCorregido.Interfaces.Atacable;
import Tema4.ExamenHerenciasCorregido.Interfaces.Atacador;

public class PokemonFuego extends Pokemon implements Atacable{

    public static final int MIN_RESISTENCIA_AGUA = 5;
    public static final int MAX_RESISTENCIA_AGUA =10;

    private int resistenciaAlAgua;
    private double bonificacionPorSol;

    public PokemonFuego(String nombre, int puntosSalud, int ataque, int defensa, double bonificacionPorSol) throws ValorNoValidoException {
        super(nombre, puntosSalud, ataque, defensa);
        bonificacionPorSol = 1d;
    }

    public void setResistenciaAlAgua(int resistenciaAlAgua) throws ValorNoValidoException{
        if (resistenciaAlAgua < MIN_RESISTENCIA_AGUA || resistenciaAlAgua > MAX_RESISTENCIA_AGUA){
            throw new ValorNoValidoException("El valor de resistencia al agua debe estar entre " + MIN_RESISTENCIA_AGUA + " y " + MAX_RESISTENCIA_AGUA);
        }
        this.resistenciaAlAgua = resistenciaAlAgua;
    }

    @Override
    public void atacar(Atacable objetivo, WeatherCondition clima) throws MuerteException {
        objetivo.recibirAtaque(clima, (int) (getAtaque() * bonificacionPorSol), this);
    }

    @Override
    public void roundStart(WeatherCondition clima) throws RoundStartException {
        if (!estaVivo()){
            return;
        }

        bonificacionPorSol = 1d;

        if (clima == WeatherCondition.SOL){
            bonificacionPorSol += Math.random();
            throw new RoundStartException("El pokémon " + getNombre() + " aumenta el ataque en esta ronda");
        }
    }

    @Override
    public void recibirAtaque(WeatherCondition clima, int puntosAtaque, Atacador atacador) throws MuerteException {
        if (atacador instanceof PokemonAgua){
            puntosAtaque -= resistenciaAlAgua;

            if (puntosAtaque < 0){
                puntosAtaque = 0;
            }
        }

        setPuntosSalud(getPuntosSalud() - puntosAtaque * (1 - getDefensa() / 100));

        if (!estaVivo()){
            throw new MuerteException("El pokémon " + getNombre() + " Ha muerto");
        }
    }
}
