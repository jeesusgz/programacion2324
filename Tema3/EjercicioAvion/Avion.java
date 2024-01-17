package Tema3.EjercicioAvion;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Avion {
    private static final int NUM_REVISIONES = 10;
    private String marca;
    private String modelo;
    private double consumo;
    private DepositoCombustible deposito;
    private RegistroRevisiones[] registro;

    public Avion(String marca, String modelo, double consumo, DepositoCombustible deposito) {
        this.marca = marca;
        this.modelo = modelo;
        this.consumo = consumo;
        this.deposito = deposito;
        this.registro = new RegistroRevisiones[10];
    }

    public void addRevision(RegistroRevisiones revision){
        for (int i = 0; i < NUM_REVISIONES; i++) {
            if (registro[i] == null){
                this.registro[i] = revision;
                break;
            }
        }
    }

    public RegistroRevisiones getultimaRevision(){
        for (int i = NUM_REVISIONES - 1; i >= 0; i--) {
            if (registro[i] != null){
                return registro[i];
            }
        }
        return null;
    }

    public boolean puedeVolar(long distancia){
        RegistroRevisiones ultimaRevision = getultimaRevision();
        double distanciaAlcanzable = deposito.getEstadoActual() / consumo;
        if (distanciaAlcanzable < distancia && ultimaRevision.isEstadoAvion() && ultimaRevision.getFecha().plusMonths(ultimaRevision.getPeriodoValidez()).isAfter(LocalDateTime.now())){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "El avion de la marca " + marca + " con el modelo "
                + modelo+" tiene un consumo de "+ consumo
                + " litros por kilometros "+ deposito
                + ". Su ultima revision fue " + getultimaRevision();
    }
}
