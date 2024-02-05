package Tema4.Boletin51.Ejercicio2;

import Tema4.EntradaSalida.Lectora;

import java.util.Scanner;

public class PrincipalVehiculo {
    private static final int MAX_VEHICULOS = 200;
    private static final Vehiculo[] listaVehiculos = new Vehiculo[MAX_VEHICULOS];

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion;
        do {
            imprimirMenu();
            opcion = teclado.nextInt();
            switch (opcion){

                case 1:
                    darAltaVehiculos();
                    break;
                case 2:
                    calcularPrecio();
                    break;
                case 3:
                    imprimirLista();
                    break;
                case 4:
                    System.out.println("Adios");
                    break;
            }
        }while (opcion != 3);
    }
    public static void imprimirMenu(){
        System.out.println("Elige una opción:");
        System.out.println("1. Alta vehiculo. ");
        System.out.println("2. Cálculo del precio del alquiler. ");
        System.out.println("3. Imprimir lista de vehículos. ");
        System.out.println("4. Salir. ");
    }
    private static void darAltaVehiculos(){
        int seleccionUsuario;
        System.out.println("estos son los vehiculos disponibles");
        int opcion = 1;
        for (TipoVehiculo tipoVehiculo : TipoVehiculo.values()){
            System.out.println(tipoVehiculo);
            System.out.println(opcion+ ". " +String.valueOf(tipoVehiculo).toLowerCase());
        }
        seleccionUsuario = Lectora.leerEnteroDeRango("Seleccion: ", TipoVehiculo.values().length, 1);
    }
    private static void calcularPrecio(){
        int posVehiculo;
        int vehiculosAlta = 0;
        String matricula =Lectora.solicitarCadenaMayus("Introduce la matricula del vehiculo: ");
        int dias = Lectora.leerEnteroDeRango("introduzca el numero de dias alquilado: ", 365, 1);
        for (posVehiculo = 0; posVehiculo < vehiculosAlta; posVehiculo++){
            if (listaVehiculos[posVehiculo].getMatricula().equals(matricula)){
                break;
            }
        }
        if (posVehiculo != vehiculosAlta){
            System.out.println("el vehiculo seleccionado con matricula: "+ matricula + " y tras ser usado por "+dias+" " +
                    "dias, esto con lleva un precio total de "+listaVehiculos[posVehiculo].getPrecioAlquiler(dias));
        }else {
            System.out.println("Su matricula no ha sido detectada ");
        }
    }
    private static void imprimirLista(){
        for (int i = 0; i < listaVehiculos.length; i++){
            System.out.println(i);
        }
    }
}
