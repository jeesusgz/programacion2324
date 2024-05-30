package Tema3_Repaso.Recuperacion;

public class DepositoGasolina {
    private boolean presion;
    private int capacidad;
    private double combustible;

    public DepositoGasolina(boolean presion, int capacidad, double combustible) throws CocheException {
        this.presion = presion;
        this.capacidad = capacidad;
        setCombustible(combustible);
    }

    public double getCombustible() {
        return combustible;
    }

    public boolean isPresion() {
        return presion;
    }

    public void setCombustible(double combustible) throws CocheException {
        if (combustible < 0 || combustible > 100){
            throw new CocheException("Nivel de combustible incorrecto");
        }
        this.combustible = combustible;
    }
}
