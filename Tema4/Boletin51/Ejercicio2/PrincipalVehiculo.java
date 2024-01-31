package Tema4.Boletin51.Ejercicio2;

import Tema4.EntradaSalida.Lectora;

import java.util.Scanner;

public class PrincipalVehiculo {
    private static final int MAX_VEHICULOS =  200;
    private static final Vehiculo[] listaVehiculos = new Vehiculo[MAX_VEHICULOS];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            imprimirMenu();
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    darAltaVehiculo();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    System.out.println("duro mi negro");
                    break;
                default:
                    System.out.println("Selecciona una opción válida");
                    break;
            }

        }while(opcion != 3);

    }

    private static void imprimirMenu(){
        System.out.println("Escoge una opción");
        System.out.println("1. Alta de Vehículo");
        System.out.println("2. Calculo de precio de alquiler");
        System.out.println("3. Listar todos los vehículos");
        System.out.println("4. Salir");
    }

    private static void darAltaVehiculo(){
        int seleccionUsuario;

        System.out.println("Estos son los vehículos disponibles");

        int i = 1;
        for(TipoVehiculo t : TipoVehiculo.values()){
            System.out.println(++i + ". " + String.valueOf(t).toLowerCase());
        }

        seleccionUsuario = Lectora.leerEnteroDeRango("Selección: ",TipoVehiculo.values().length,1);


    }
}
