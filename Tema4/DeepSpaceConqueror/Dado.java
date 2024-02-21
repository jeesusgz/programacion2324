package Tema4.DeepSpaceConqueror;

import java.util.Random;

public class Dado implements ILanzable{

    public static final int NUM_MIN_CARAS = 4;

    private int caras;
    private int numMin;

    public Dado(int caras, int numMin)throws InvalidValueException {
        /*
        Realizo aquí las comprobaciones porque no vamos a cambiar nunca el número minimo
        de caras en el dado ni el valor mínimo de del dado.
         */
        if (caras < Dado.NUM_MIN_CARAS){
            throw new InvalidValueException("El dado debe tener como mínimo " + Dado.NUM_MIN_CARAS + " caras");
        }

        if (numMin < 1){
            throw new InvalidValueException("El valor más pequeño posible es 1");
        }

        this.caras = caras;
        this.numMin = numMin;
    }

    /**
     *
     * @return un valor entre el valor entre la cara más pequeña y la más grande con la misma probabilidad
     */
    @Override
    public int lanzar() {
        Random r = new Random();
        return r.nextInt(caras) + numMin;
    }

    @Override
    public int getMin() {
        return numMin;
    }

    @Override
    public int getMax() {
        return numMin + caras - 1;
    }
}
