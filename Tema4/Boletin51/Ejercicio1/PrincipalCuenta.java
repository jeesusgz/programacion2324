package Tema4.Boletin51.Ejercicio1;

import java.util.Scanner;

public class PrincipalCuenta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CuentaCredito cuenta = new CuentaCredito();
        int opcion = 0;

        do {
            menu();
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("Inserte el dinero a ingresar");
                    double dineroAIngresar = sc.nextDouble();
                    try {
                        cuenta.ingresarDinero(dineroAIngresar);
                    } catch (CuentaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("inserte el dinero a retirar");
                    double dineroARetirar = sc.nextDouble();
                    try {
                        cuenta.ingresarDinero(dineroARetirar);
                    } catch (CuentaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println(cuenta);
                    break;
                case 4:
                    System.out.println("adio chava");
                    break;
                default:
                    System.out.println("Seleccione una opción válida");
            }

        }while (opcion != 4);
    }

    public static void menu(){
        System.out.println("Bienvenido a su cuenta selecciona la operación que desea realizar");

        System.out.println("1. Ingresar dinero");
        System.out.println("2. Sacar dinero");
        System.out.println("3. Mostrar saldo y crédito de la cuenta");
        System.out.println("4. Salir");
    }
}
