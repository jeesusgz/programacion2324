package Tema4.DeepSpaceConqueror;

public class Nave extends Carta implements IAtacable, IReparable{

    protected static final int PUNTOS_REPARACION_NAVE = 10;

    protected int puntosDefensa;
    private Jugador jugador;

    /**
     * Crea la nave
     * @param nombre el nombre de la carta. Normalmente Nave
     * @param precio el precio de la carta en unidades de oro
     * @param puntosDefensa los puntos de defensa de la nave
     * @throws InvalidValueException si el precio es menor que 0
     */
    public Nave(String nombre, int precio, int puntosDefensa) throws InvalidValueException {
        super(nombre, precio);

        this.puntosDefensa = puntosDefensa;
    }

    @Override
    public int getPuntosDefensa() {
        return this.puntosDefensa;
    }

    @Override
    public void serAtacado(int puntosDaño) throws InvalidValueException, DestructionException {
        if (puntosDaño < 0){
            throw new InvalidValueException("El daño infligido no puede ser menor a 0");
        }

        puntosDefensa -= puntosDaño;

        if (puntosDefensa <= 0){
            throw new DestructionException("La nave " + super.getNombre() + " ha sido destruida");
        }
    }

    /**
     * Aumenta los puntos de defensa de la nave. En principio, no hay limite superior
     */
    @Override
    public void reparar() {
        this.puntosDefensa += Nave.PUNTOS_REPARACION_NAVE;
    }

    public void asignarJugador(Jugador j){
        this.jugador = j;
    }

    /**
     * Devuelve el jugador dueño de la carta, o null si no tiene dueño
     * @return el juagdor dueño de la carta, o null si no tiene dueño
     */
    public Jugador getJugador() {
        return jugador;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Nave{");
        sb.append("puntosDefensa=").append(puntosDefensa);
        sb.append(", jugador=").append(jugador);
        sb.append('}');
        return sb.toString();
    }
}
