package Tema4.ExamenHerencias.Interfaces;

import Tema4.ExamenHerencias.Exceptions.MuerteException;
import Tema4.ExamenHerencias.Exceptions.ValorNoValidoException;

public interface Atacable {
    public void serAtacado() throws ValorNoValidoException, MuerteException;
}
