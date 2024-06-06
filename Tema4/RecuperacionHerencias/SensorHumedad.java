package Tema4.RecuperacionHerencias;

public class SensorHumedad extends Sensor implements AutoChequeable{
    private double relativa;
    private double absoluta;

    public SensorHumedad(String marca, String modelo, String identificador, boolean activo, double relativa, double absoluta) throws ValorInvalidoException {
        super(marca, modelo, identificador, activo);
        setRelativa(relativa);
        setAbsoluta(absoluta);
    }

    public double getRelativa() {
        return relativa;
    }

    public double getAbsoluta() {
        return absoluta;
    }

    public void setRelativa(double relativa) throws ValorInvalidoException {
        if (relativa < 0 || relativa > 100){
            throw new ValorInvalidoException("Humedad incorrecta");
        }
        this.relativa = relativa;
    }

    public void setAbsoluta(double absoluta) throws ValorInvalidoException {
        if (absoluta < 0 || absoluta > 100){
            throw new ValorInvalidoException("Humedad incorrecta");
        }
        this.absoluta = absoluta;
    }

    @Override
    public void devolverInfo() {
        System.out.println("Hace una humedad relativa de " + relativa + " y una humedad absoluta de " + absoluta);
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
