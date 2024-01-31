package Tema4.Boletin51.Ejercicio2;

public class Furgoneta extends Vehiculo{
    private static final double PRECIO_KILOS = 0.5;
    private int pma;

    public Furgoneta(String matricula, Gama gama, int pma) throws VehiculoException {
        super(matricula, gama);
        setPma(pma);
    }

    public void setPma(int pma) throws VehiculoException {
        if (pma < 1){
            throw new VehiculoException("PMA inválido");
        }

        this.pma = pma;
    }

    @Override
    public double getPrecioDiario() {
        return getGama().getPrecioDia() + PRECIO_KILOS * pma;
    }
}
