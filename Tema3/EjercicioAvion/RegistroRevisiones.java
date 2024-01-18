package Tema3.EjercicioAvion;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistroRevisiones {
    private boolean estadoAvion;
    private LocalDateTime fecha;
    private int periodoValidez;

    public RegistroRevisiones(boolean estadoAvion, LocalDateTime fecha, int periodoValidez) {
        if (fecha.isBefore(LocalDateTime.now())){
            this.fecha = fecha;
        }
        this.estadoAvion = estadoAvion;

        if (periodoValidez > 0){
            this.periodoValidez = periodoValidez;
        }
    }

    public boolean isEstadoAvion(){
        return estadoAvion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public int getPeriodoValidez() {
        return periodoValidez;
    }

    @Override
    public String toString() {
        DateTimeFormatter formateo = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return fecha.format(formateo) + " con resultado " + (estadoAvion ? "Satisfactorio con una validez de " + periodoValidez + " meses" : "No satisfactorio");
    }
}
