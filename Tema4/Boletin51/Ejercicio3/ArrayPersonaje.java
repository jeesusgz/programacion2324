package Tema4.Boletin51.Ejercicio3;

public class ArrayPersonaje implements CreableEstadisticas{
    public static final int NUM_MAX_PERSONAJES = 100;
    private Personaje[] personajes;

    public ArrayPersonaje() {
        this.personajes = new Personaje[NUM_MAX_PERSONAJES];
    }

    @Override
    public double minimo() throws PersonajeException{
        double vidaMin = Personaje.VIDA_MAX;
        int cont = 0;
        for (int i = 0; i < personajes.length; i++) {
            if (personajes[i] != null){
                cont++;
                if (vidaMin > personajes[i].getVidaActual()){
                    vidaMin = personajes[i].getVidaActual();
                }
            }
        }
        if (cont == 0){
            throw new PersonajeException("No hay personajes");
        }
        return vidaMin;
    }

    @Override
    public double maximmo() throws PersonajeException{
        double vidaMax = Personaje.VIDA_MIN;
        int cont = 0;
        for (int i = 0; i < personajes.length; i++) {
            if (personajes[i] != null){
                cont++;
                if (vidaMax < personajes[i].getVidaActual()){
                    vidaMax = personajes[i].getVidaActual();
                }
            }
        }
        if (cont == 0){
            throw new PersonajeException("No hay personajes");
        }
        return vidaMax;
    }

    @Override
    public double media() throws PersonajeException{
        double valorVida = 0;
        int cont = 0;
        for (int i = 0; i < personajes.length; i++) {
            if (personajes[i] != null){
                cont++;
                valorVida += personajes[i].getVidaActual();
            }
        }
        if (cont == 0){
            throw new PersonajeException("No hay personajes");
        }
        return valorVida / cont;
    }
}
