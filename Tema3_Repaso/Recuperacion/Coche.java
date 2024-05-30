package Tema3_Repaso.Recuperacion;

public class Coche {
    private String marca;
    private String modelo;
    private TColor color;
    private Motor motor;
    private Bateria bateria;
    private DepositoGasolina deposito;
    private CajaCambios cajaCambios;

    public Coche(String marca, String modelo, TColor color, Motor motor, Bateria bateria, DepositoGasolina deposito, CajaCambios cajaCambios) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.motor = motor;
        this.bateria = bateria;
        this.deposito = deposito;
        this.cajaCambios = cajaCambios;
    }

    public void arrancar() throws CocheException {
        if (motor.getNumAceite() < 0.96 || motor.getNumAceite() > 0.98){
            throw new CocheException("El coche no tiene suficiente Aceite para arrancar");
        }

        if (bateria.getCargaBateria() < 5){
            throw new CocheException("El coche no tiene suficiente carga en la batería para arrancar");
        }

        if (motor.getNivelAgua() < 0.7){
            throw new CocheException("El motor del coche no tiene suficiente agua para arrancar");
        }

        if (motor.getTemperatura() > 0.95){
            throw new CocheException("El motor del coche está sobrecalentado y no puede arrancar");
        }

        if (deposito.getCombustible() < 0 || !deposito.isPresion()){
            throw new CocheException("El coche no tiene combustible o presión para arrancar ");
        }

        if (!cajaCambios.isEstado()){
            throw new CocheException("La caja de cambios no funciona");
        }

        System.out.println("El coche ha arrancado");
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Coche{");
        sb.append("marca='").append(marca).append('\'');
        sb.append(", modelo='").append(modelo).append('\'');
        sb.append(", color=").append(color);
        sb.append(", motor=").append(motor);
        sb.append('}');
        return sb.toString();
    }
}
