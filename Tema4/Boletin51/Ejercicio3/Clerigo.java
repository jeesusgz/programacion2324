package Tema4.Boletin51.Ejercicio3;

public class Clerigo extends Personaje{
    public static final int FUERZA_MAX = 18;
    public static final int INTELIGENCIA_MIN = 12;
    public static final int INTELIGENCIA_MAX = 16;
    public static final int CURACION = 10;
    private final String diosDeClerigo;

    public Clerigo(String nombre, Raza raza, int fuerza, int inteligencia, int vidaMax, String diosDeClerigo) throws PersonajeException {
        super(nombre, raza, fuerza, inteligencia, vidaMax);
        this.diosDeClerigo = diosDeClerigo;
    }

    public String getDiosDeClerigo() {
        return diosDeClerigo;
    }

    public void curar(Personaje personaje) throws PersonajeException{
        if (this == personaje){
            throw new PersonajeException("No puedes curarte a ti mismo");
        }

        if (personaje.getVidaActual() == Personaje.VIDA_MIN){
            throw new PersonajeException("Está muerto, no puedes curarlo");
        }
        personaje.setVidaActual(personaje.getVidaActual() + CURACION);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Clerigo{");
        sb.append("diosDeClerigo='").append(diosDeClerigo).append('\'');
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
