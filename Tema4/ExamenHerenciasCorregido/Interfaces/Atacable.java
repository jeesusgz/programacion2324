package Tema4.ExamenHerenciasCorregido.Interfaces;

import Tema4.ExamenHerenciasCorregido.Enums.WeatherCondition;
import Tema4.ExamenHerenciasCorregido.Exceptions.MuerteException;

public interface Atacable {
    public void recibirAtaque(WeatherCondition clima, int puntosAtaque, Atacador atacador) throws MuerteException;
}
