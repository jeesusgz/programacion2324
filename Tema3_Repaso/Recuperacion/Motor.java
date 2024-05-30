package Tema3_Repaso.Recuperacion;

public class Motor {
    private String marca;
    private String modelo;
    private String numSerie;
    private int kilometros;
    private double numAceite;
    private double NivelAgua;
    private double temperatura;

    public Motor(String marca, String modelo, String numSerie, int kilometros, double numAceite, double nivelAgua, double temperatura) throws CocheException {
        this.marca = marca;
        this.modelo = modelo;
        this.numSerie = numSerie;
        this.kilometros = kilometros;
        setNumAceite(numAceite);
        setNivelAgua(nivelAgua);
        setTemperatura(temperatura);
    }

    public double getNumAceite() {
        return numAceite;
    }

    public double getNivelAgua() {
        return NivelAgua;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setNumAceite(double numAceite) throws CocheException {
        if (numAceite < 0 || numAceite > 1){
            throw new CocheException("Nivel de aceite es incorrecto");
        }
        this.numAceite = numAceite;
    }

    public void setNivelAgua(double nivelAgua) throws CocheException {
        if (nivelAgua < 0 || nivelAgua > 1){
            throw new CocheException("Nivel de agua es incorrecto");
        }
        NivelAgua = nivelAgua;
    }

    public void setTemperatura(double temperatura) throws CocheException {
        if (temperatura < 0 || temperatura > 1){
            throw new CocheException("temperatura incorrecta");
        }
        this.temperatura = temperatura;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Motor{");
        sb.append("marca='").append(marca).append('\'');
        sb.append(", modelo='").append(modelo).append('\'');
        sb.append(", numSerie='").append(numSerie).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
