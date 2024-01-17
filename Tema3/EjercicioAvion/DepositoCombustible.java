package Tema3.EjercicioAvion;

import java.time.LocalDateTime;

public class DepositoCombustible {
    private double capacidadMax;
    private double estadoActual;

    public DepositoCombustible(double capacidadMax, double estadoActual) {
        this.capacidadMax = capacidadMax;
        setEstadoActual(estadoActual);
    }

    public DepositoCombustible(LocalDateTime of, boolean b, int i){

    }



    public double getCapacidadMax() {
        return capacidadMax;
    }

    public void setCapacidadMax(double capacidadMax) {
        this.capacidadMax = capacidadMax;
    }

    public double getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(double estadoActual) {
        if (estadoActual < capacidadMax && estadoActual > 0){
            this.estadoActual = estadoActual;
        }
    }

    @Override
    public String toString() {
        return estadoActual / capacidadMax * 100 + "% de un deposito de litros";
    }
}
