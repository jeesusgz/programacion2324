package Tema4.RecuperacionHerencias;

public class SensorViento extends Sensor implements AutoChequeable{
    private DireccionActual direccionActual;
    private double velocidadActual;
    private double rachaMaximaUltimaHora;

    public SensorViento(String marca, String modelo, String identificador, boolean activo, DireccionActual direccionActual, double velocidadActual) {
        super(marca, modelo, identificador, activo);
        this.direccionActual = direccionActual;
        this.velocidadActual = velocidadActual;
    }

    public DireccionActual getDireccionActual() {
        return direccionActual;
    }

    public double getVelocidadActual() {
        return velocidadActual;
    }

    @Override
    public void devolverInfo() {
        System.out.println("Hace rachas de viento con velocidad actual de " + velocidadActual + " y rachas máximas de última hora de " + rachaMaximaUltimaHora);
    }


    @Override
    public void estado(boolean estado) {
        if (estado){
            System.out.println("Correcto");
        }else {
            System.out.println("Defectuoso");
        }
    }
}
