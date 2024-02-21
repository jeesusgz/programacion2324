package Tema4.DeepSpaceConqueror;

public class Construccion extends Carta{

    private int personasAsignadas;
    public Construccion(String nombre, int precio, int personasAsignadas) throws InvalidValueException {
        super(nombre, precio);

        this.personasAsignadas = personasAsignadas;
    }

    public int getPersonasAsignadas() {
        return personasAsignadas;
    }
}
