package Tema4.ExamenHerenciasCorregido.Model;

import Tema4.ExamenHerenciasCorregido.Enums.WeatherCondition;
import Tema4.ExamenHerenciasCorregido.Exceptions.MuerteException;
import Tema4.ExamenHerenciasCorregido.Exceptions.RoundStartException;
import Tema4.ExamenHerenciasCorregido.Exceptions.ValorNoValidoException;
import Tema4.ExamenHerenciasCorregido.Interfaces.Atacable;
import Tema4.ExamenHerenciasCorregido.Interfaces.Atacador;

public class PokemonAgua extends Pokemon implements Atacable{

    private static final int MIN_HIDRATACION = 10;
    private static final int MAX_HIDRATACION = 20;

    private int hidratacion;
    private double precisionPorLluvia;

    public PokemonAgua(String nombre, int puntosSalud, int ataque, int defensa, int hidratacion) throws ValorNoValidoException{
        super(nombre, puntosSalud, ataque, defensa);
        setHidratacion(hidratacion);
        precisionPorLluvia = 1d;
    }

    public void setHidratacion(int hidratacion) throws ValorNoValidoException{
        if (hidratacion < MIN_HIDRATACION || hidratacion > MAX_HIDRATACION){
            throw new ValorNoValidoException("Hidratacion debe estar entre " + MIN_HIDRATACION + " y " + MAX_HIDRATACION);
        }
        this.hidratacion = hidratacion;
    }

    @Override
    public void atacar(Atacable objetivo, WeatherCondition clima) throws MuerteException {
        objetivo.recibirAtaque(clima, (int) (getAtaque() * precisionPorLluvia), this);
    }

    @Override
    public void roundStart(WeatherCondition clima) throws RoundStartException {
        if (!estaVivo()){
            return;
        }

        precisionPorLluvia = 1d;

        if (clima == WeatherCondition.LLUVIA){
            setPuntosSalud(getPuntosSalud() + hidratacion);
            precisionPorLluvia += Math.random();
            throw new RoundStartException("El pokémon " + getNombre() + " recibe una curación por lluvia y una bonificación de daño");
        }
    }

    @Override
    public void recibirAtaque(WeatherCondition clima, int puntosAtaque, Atacador atacador) throws MuerteException {
        setPuntosSalud(getPuntosSalud() - puntosAtaque * (1 - getDefensa() / 100));

        if (!estaVivo()){
            throw new MuerteException("El pokémon " + getNombre() + " Ha muerto");
        }
    }
}
