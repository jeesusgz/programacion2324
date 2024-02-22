package Tema4.DeepSpaceConqueror;

public class NaveTransporte extends Nave implements ITransportable, IMejorable{

    private static final int MEJORA_NAVE_TRANSPORTE = 2;
    private static final int PRECIO_CARTA_NAVE_TRANSPORTE = 2;
    private static final int PUNTOS_DEFENSA_INICIAL_TRANSPORTE = 4;

    private int capacidad;

    /**
     * Constructor de una carta de nave de transporte
     * @param nombre nombre de la nave
     * @throws InvalidValueException si la capacidad de pasajeros introducida es menor que 0 o el nombre no es válido
     */
    public NaveTransporte(String nombre) throws InvalidValueException {
        super(nombre, NaveTransporte.PRECIO_CARTA_NAVE_TRANSPORTE, NaveTransporte.PUNTOS_DEFENSA_INICIAL_TRANSPORTE);
    }

    /**
     * Asigna la capacidad de transporte después de lanzar el dado.
     * @param capacidad la capacidad de transporte de la nave
     * @throws InvalidValueException si la capacidad es 0 o negativo
     */
    public void setCapacidad(int capacidad) throws InvalidValueException{
        if (this.capacidad <= 0){
            throw new InvalidValueException("La capacidad de la nave debe ser al menos 1 ocupante");
        }

        this.capacidad = capacidad;
    }

    /**
     * resetea la capacidad a 0. Normalmente debido a una acción cancelada
     */
    public void resetCapacidad(){
        this.capacidad = 0;
    }

    @Override
    public void transportar(Planeta destino, int personas) throws InvalidValueException, JuegoException {

    }

    /**
     * mejora la capacidad de la nave por un factor multiplicador
     */
    @Override
    public void mejorar() {
        this.capacidad *= NaveTransporte.MEJORA_NAVE_TRANSPORTE;
    }

    /**
     * @return la capacidad de pasajeros de la nave
     */
    public int getCapacidad() {
        return capacidad;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NaveCarga{");
        sb.append(". Capacidad de transporte: ");

        if (this.capacidad == 0){
            sb.append("Lanzar dado para ver");
        }else {
            sb.append(this.capacidad).append(" pasajeros");
        }
        return sb.toString();
    }
}
