package Tema4.RecuperacionHerencias;

public abstract class Sensor {
    private String marca;
    private String modelo;
    private String identificador;
    private boolean activo;

    public Sensor(String marca, String modelo, String identificador, boolean activo) {
        this.marca = marca;
        this.modelo = modelo;
        this.identificador = identificador;
        this.activo = activo;
    }

    public boolean isActivo() {
        return activo;
    }

    public abstract void devolverInfo();
}
