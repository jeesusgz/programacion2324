package Tema4.DeepSpaceConqueror;

public interface IAtacador {
    /**
     * Ataca un objetivo que sea atacable
     * @param objetivo el objetivo al que se ataca
     * @throws InvalidValueException si el poder con el que se ataca al objetivo es menor que 0
     * @throws DestructionException si el objetivo ha sido destruido tras el ataque
     * @throws JuegoException si el objetivo no puede ser atacado en ciertas condiciones
     */
    public void atacar(IAtacable objetivo) throws InvalidValueException, DestructionException, JuegoException;
}
