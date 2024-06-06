package Tema4.RecuperacionHerencias;

public class Estacion {
    private String ciudad;
    private SensorViento sensorViento;
    private SensorHumedad sensorHumedad;
    private SensorTemperatura sensorTemperatura;
    private TermometroInfrarrojos sensorInfrarrojos;
    private TermometroMercurio sensorMercurio;

    public Estacion(String ciudad, SensorViento sensorViento, SensorHumedad sensorHumedad, SensorTemperatura sensorTemperatura) {
        this.ciudad = ciudad;
        this.sensorViento = sensorViento;
        this.sensorHumedad = sensorHumedad;
        this.sensorTemperatura = sensorTemperatura;
    }

    public void detectarLluvia(){
        if (sensorViento.getVelocidadActual() > 20 && sensorViento.getDireccionActual().equals("N")
                && sensorViento.getVelocidadActual() > 30 && !sensorViento.getDireccionActual().equals("N")
                && sensorHumedad.getRelativa() > 70 && sensorHumedad.getAbsoluta() > 77
                && sensorTemperatura.getGradosCelsius() < 20){
            System.out.println("En las dos próximas horas lloverá");
        }else {
            System.out.println("En las dos próximas horas NO lloverá");
        }
    }

    public void checkEstacion() throws PredecirException {
        if (!sensorViento.isActivo() || !sensorHumedad.isActivo() || !sensorTemperatura.isActivo()){
            throw new PredecirException("la estación no puede predecir el clima");
        }


    }
}
