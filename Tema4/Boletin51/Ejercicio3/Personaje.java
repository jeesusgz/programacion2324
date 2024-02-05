package Tema4.Boletin51.Ejercicio3;

public class Personaje {
    public static final int FUERZA_MAX = 20;
    public static final int FUERZA_MIN = 0;
    public static final int INTELIGENCIA_MAX = 20;
    public static final int INTELIGENCIA_MIN = 0;
    public static final int VIDA_MAX = 100;
    public static final int VIDA_MIN = 0;
    private String nombre;
    private Raza raza;
    private int fuerza;
    private int inteligencia;
    private int vidaMax;
    private int vidaActual;

    public Personaje(String nombre, Raza raza, int fuerza, int inteligencia, int vidaMax) throws PersonajeException {
        this.nombre = nombre;
        this.raza = raza;
        setFuerza(fuerza);
        setInteligencia(inteligencia);
        setVidaMax(vidaMax);
        setVidaActual(vidaMax);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public void setFuerza(int fuerza) throws PersonajeException {
        if (fuerza < FUERZA_MIN || fuerza > FUERZA_MAX) {
            throw new PersonajeException("Valor de la fuerza no valida");
        }
        this.fuerza = fuerza;
    }

    public void setInteligencia(int inteligencia) throws PersonajeException {
        if (inteligencia < INTELIGENCIA_MIN || inteligencia > INTELIGENCIA_MAX) {
            throw new PersonajeException("Valor de la inteligencia no valida");
        }
        this.inteligencia = inteligencia;
    }

    public void setVidaMax(int vidaMax) throws PersonajeException {
        if (vidaMax < VIDA_MIN || fuerza > VIDA_MAX) {
            throw new PersonajeException("Valor de la vida maxima no es valida");
        }
        this.vidaMax = vidaMax;
    }

    public void setVidaActual(int vidaActual) {
        if (vidaActual < VIDA_MIN ) {
            this.vidaActual = VIDA_MIN;
        }else if (vidaActual > vidaMax){
            this.vidaActual = vidaMax;
        }else {
            this.vidaActual = vidaActual;
        }
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "nombre='" + nombre + '\'' +
                ", raza=" + raza +
                ", fuerza=" + fuerza +
                ", inteligencia=" + inteligencia +
                ", vidaMax=" + vidaMax +
                ", vidaActual=" + vidaActual +
                '}';
    }
}
