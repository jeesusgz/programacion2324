package Tema4.DeepSpaceConqueror;

public interface ITransportable {
    /**
     * Transporta un número de personas determinado al planeta destino
     * @param destino el planeta al que serán transportadas las personas
     * @param personas el número de personas a transportar
     * @throws InvalidValueException si el número de personas es menor que 0 o mayor que las existentes
     * @throws JuegoException si el planeta destino está conquistado por otro juaador
     */
    public void transportar(Planeta destino, int personas) throws InvalidValueException, JuegoException;
}
