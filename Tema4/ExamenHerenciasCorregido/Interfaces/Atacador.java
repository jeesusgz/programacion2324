package Tema4.ExamenHerenciasCorregido.Interfaces;

import Tema4.ExamenHerenciasCorregido.Enums.WeatherCondition;
import Tema4.ExamenHerenciasCorregido.Exceptions.MuerteException;

public interface Atacador {
    public void atacar(Atacable objetivo, WeatherCondition clima) throws MuerteException;
}
