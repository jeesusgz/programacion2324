package Tema3.EjercicioAvion;

import java.time.LocalDateTime;

public class AvionPrincipal {
    public static void main(String[] args) {
        DepositoCombustible d = new DepositoCombustible(200.000, 100.000);

        Avion a = new Avion("A230", "AIRBUS", 13, d);

        a.addRevision(new RegistroRevisiones(true, LocalDateTime.of(2022,12,21,1,20), 10));

        System.out.println(a);
        System.out.println(a.puedeVolar(150000)? "Puedes recorrer esa distancia " : "No puede volar");
    }
}
