package Tema4.RecuperacionHerencias;

public class SensorTemperatura extends Sensor{
    private double gradosCelsius;


    public SensorTemperatura(String marca, String modelo, String identificador, boolean activo, double gradosCelsius) {
        super(marca, modelo, identificador, activo);
        this.gradosCelsius = gradosCelsius;
    }

    public double getGradosCelsius() {
        return gradosCelsius;
    }

    @Override
    public void devolverInfo() {
        System.out.println("Hace una temperatura de " + gradosCelsius + " grados centigrados");
    }
}
