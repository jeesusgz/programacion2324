package Tema5.Examen2022.Model;

public abstract class Cromo {
    private int id;

    public Cromo(int id) {
        this.id = id;
    }

    public abstract String getEquipo();
}
