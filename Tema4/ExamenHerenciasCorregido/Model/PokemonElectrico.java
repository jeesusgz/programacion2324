package Tema4.ExamenHerenciasCorregido.Model;

import Tema4.ExamenHerenciasCorregido.Enums.WeatherCondition;
import Tema4.ExamenHerenciasCorregido.Exceptions.MuerteException;
import Tema4.ExamenHerenciasCorregido.Exceptions.RoundStartException;
import Tema4.ExamenHerenciasCorregido.Exceptions.ValorNoValidoException;
import Tema4.ExamenHerenciasCorregido.Interfaces.Atacable;
import Tema4.ExamenHerenciasCorregido.Interfaces.Atacador;

public class PokemonElectrico extends Pokemon implements Atacable{

    public static final int MIN_REDUCCION_DAMAGE_LLUVIA = 10;
    public static final int MAX_REDUCCION_DAMAGE_LLUVIA = 15;

    private int reduccionDamageLluvia;
    private double bonificacionTormentaElectrica;
    public PokemonElectrico(String nombre, int puntosSalud, int ataque, int defensa, int reduccionDamageLluvia) throws ValorNoValidoException {
        super(nombre, puntosSalud, ataque, defensa);
        bonificacionTormentaElectrica = 1d;
    }

    public void setReduccionDamageLluvia(int reduccionDamageLluvia) throws ValorNoValidoException{
        if (reduccionDamageLluvia < MIN_REDUCCION_DAMAGE_LLUVIA || reduccionDamageLluvia > MAX_REDUCCION_DAMAGE_LLUVIA){
            throw new ValorNoValidoException("El valor de reduccion del daño por lluvia debe estar entre " + MIN_REDUCCION_DAMAGE_LLUVIA + " y " + MAX_REDUCCION_DAMAGE_LLUVIA);
        }
        this.reduccionDamageLluvia = reduccionDamageLluvia;
    }

    @Override
    public void atacar(Atacable objetivo, WeatherCondition clima) throws MuerteException {
        //todo terminar
    }

    @Override
    public void roundStart(WeatherCondition clima) throws RoundStartException {
        if (!estaVivo()){
            return;
        }
        if (clima == WeatherCondition.TORMENTA_ELECTRICA) {
            this.bonificacionTormentaElectrica += Math.random();
            throw new RoundStartException("En esta ronda, " + getNombre() + " aumenta su ataque por el sol");
        } else if (clima == WeatherCondition.LLUVIA) {
            this.bonificacionTormentaElectrica = 1d;
            throw new RoundStartException("En esta ronda, " + getNombre() + " disminuye el daño recibido gracias a la lluvia");
        } else {
            this.bonificacionTormentaElectrica = 1d;
        }
    }

    @Override
    public void recibirAtaque(WeatherCondition clima, int puntosAtaque, Atacador atacador) throws MuerteException {

    }
}
