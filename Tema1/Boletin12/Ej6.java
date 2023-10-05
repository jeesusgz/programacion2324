package Tema1.Boletin12;

import java.util.Scanner;

public class Ej6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el tipo de vehículo");
        String tipoVehiculo =  sc.nextLine();

        //equals es para comparar para el tipo String

        if (tipoVehiculo.equals("coche")){
            System.out.println("La velocidad es de 120km/h");
        }else {
            if (tipoVehiculo.equals("moto")){
                System.out.println("La velocidad es de 90km/h");
            }else{
                if (tipoVehiculo.equals("camión")){
                    System.out.println("La velocidad es de 80km/h");
                }else {
                    System.out.println("No conozco  ese vehículo");
                }
            }
        }
    }
}
