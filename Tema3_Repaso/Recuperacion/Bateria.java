package Tema3_Repaso.Recuperacion;

public class Bateria {
    private int capapcidadBateria;
    private double voltaje;
    private double cargaBateria;

    public Bateria(int capacidadBateria, double voltaje, double cargaBateria) throws CocheException {
        this.capapcidadBateria = capacidadBateria;
        this.voltaje = voltaje;
        setCargaBateria(cargaBateria);
    }

    public double getCargaBateria() {
        return cargaBateria;
    }

    public double getVoltaje() {
        return voltaje;
    }

    public void setCargaBateria(double cargaBateria) throws CocheException {
        if (cargaBateria < 0 || cargaBateria > 100){
            throw new CocheException("Carga de la batería incorrecto");
        }
        this.cargaBateria = cargaBateria;
    }


}
