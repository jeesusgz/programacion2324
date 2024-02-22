package Tema4.ExamenHerencias.Interfaces;

import Tema4.ExamenHerencias.Enums.WeatherCondition;
import Tema4.ExamenHerencias.Exceptions.MuerteException;
import Tema4.ExamenHerencias.Exceptions.ValorNoValidoException;

public interface Atacador {
    public void atacar(Atacable objetivo, WeatherCondition clima)throws MuerteException, ValorNoValidoException;
}
