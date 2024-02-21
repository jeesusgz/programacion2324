package Tema4.DeepSpaceConqueror;

public interface IAtacable {
    /**
     * Devuelve los puntos de defensa del objeto
     * @return los puntos de defensa
     */
    public int getPuntosDefensa();

    /**
     * Resta al objeto los puntos de defensa que le inflige el ataque.
     * @param puntosDaño El daño que le inflingen. Si el resultado de restar los puntos es negativo, se lanzará
     *                   una excepción DestructionException
     * @throws InvalidValueException si puntosDaño es 0 o negativo
     * @throws DestructionException si el objetivo ha sido destruido
     * @throws JuegoException si el objetivo no puede ser atacddo
     */
    public void serAtacado(int puntosDaño) throws InvalidValueException, DestructionException, JuegoException;
}
