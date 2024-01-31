package Tema4.Boletin51.Ejercicio2;

public abstract class Vehiculo {
    private String matricula;
    private Gama gama;
    private double alquiler;

    public Vehiculo(String matricula, Gama gama) {
        this.matricula = matricula;
        this.gama = gama;
    }

    public String getMatricula() {
        return matricula;
    }

    public Gama getGama() {
        return gama;
    }

    public abstract double getPrecioDiario();
    public double getPrecioAlquiler(int numDias){

        return getPrecioDiario() * numDias;
    }


}
