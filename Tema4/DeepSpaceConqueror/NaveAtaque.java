package Tema4.DeepSpaceConqueror;

public class NaveAtaque extends Nave implements IAtacador, IMejorable{

    private static final int PODER_ATAQUE_DEFAULT = 3;
    private static final int PRECIO_CARTA_NAVE_ATAQUE = 5;
    private static final int PUNTOS_DEFENSA_INICIAL_ATAQUE = 7;

    private int poderAtaque;

    public NaveAtaque(String nombre) throws InvalidValueException {
        super(nombre, NaveAtaque.PRECIO_CARTA_NAVE_ATAQUE, NaveAtaque.PUNTOS_DEFENSA_INICIAL_ATAQUE);

        this.poderAtaque = NaveAtaque.PODER_ATAQUE_DEFAULT;
    }

    @Override
    public void atacar(IAtacable objetivo) throws InvalidValueException, DestructionException, JuegoException {
        if (objetivo == null){
            throw new InvalidValueException("El objetivo no existe");
        }

        objetivo.serAtacado(this.poderAtaque);
    }

    /**
     * @return el poder de ataque de la nave
     */
    public int getPoderAtaque() {
        return poderAtaque;
    }

    @Override
    public void mejorar() {
        this.poderAtaque += NaveAtaque.PODER_ATAQUE_DEFAULT;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NaveAtaque{");
        sb.append("poderAtaque=").append(poderAtaque);
        sb.append('}');
        return sb.toString();
    }
}
