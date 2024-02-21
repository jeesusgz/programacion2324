package Tema4.DeepSpaceConqueror;

public class EscudoProtector extends Construccion implements IAtacable, IReparable{

    public static final int PERSONAS_ASIGNADAS_ESCUDO_PROTECTOR = 15;
    public static final int PRECIO_CARTA_ESCUDO_PROTECTOR = 5;
    public static final int PUNTOS_DEFENSA_INICIAL_ESCUDO_PROTECTOR = 20;
    public static final int PUNTOS_REPARACION_ESCUDO_PROTECTOR = 15;

    private int puntosDefensa;

    /**
     * constructor de una carta de escudo
     * @param nombre El nombre de la carta
     * @throws InvalidValueException si los puntos de defensa extra son negativos
     */
    public EscudoProtector(String nombre) throws InvalidValueException {
        super(nombre, EscudoProtector.PRECIO_CARTA_ESCUDO_PROTECTOR,EscudoProtector.PERSONAS_ASIGNADAS_ESCUDO_PROTECTOR);
    }

    @Override
    public int getPuntosDefensa() {
        return this.puntosDefensa;
    }

    @Override
    public void serAtacado(int puntosDaño) throws InvalidValueException, DestructionException, JuegoException {
        if (puntosDaño < 0){
            throw new InvalidValueException("El daño inflinngido no puede ser menos a 0");
        }

        puntosDefensa -= puntosDaño;

        if (puntosDefensa <= 0){
            throw new DestructionException("El escudo " + super.getNombre() + " Ha sido destruido");
        }
    }

    @Override
    public void reparar() {
        puntosDefensa += EscudoProtector.PUNTOS_REPARACION_ESCUDO_PROTECTOR;
    }

    public void setPuntosDefensa(int puntosDefensa) throws InvalidValueException{
        if (puntosDefensa < 0){
            throw new InvalidValueException("No puedes restar puntos a la defensa inicial del escudo");
        }

        this.puntosDefensa = PUNTOS_DEFENSA_INICIAL_ESCUDO_PROTECTOR + puntosDefensa;
    }
}
