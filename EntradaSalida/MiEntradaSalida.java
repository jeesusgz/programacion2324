package EntradaSalida;

import java.util.Scanner;

public class MiEntradaSalida {
    public static Scanner sc = new Scanner(System.in);

    public static int leerEntero(String mensaje){
        System.out.printf(mensaje + ": ");

        //TODO Controlar excepción
        return Integer.parseInt(sc.nextLine());
    }

    /**
     * Lee un entero y comprueba si es positivo
     * @param mensaje lee el mensaje que ha insertado el usuario
     * @param positivo valor positivo
     * @return devuelve un valor positivo
     */
    public static int LeerEnteroPositivo(String mensaje, int positivo){
        if (positivo < 0){
            //TODO Controlar excepcion
        }

        System.out.printf(mensaje + ": ");

        int numeroLeido;

        do {
            numeroLeido = Integer.parseInt(sc.nextLine());

            if (numeroLeido< 0){
                System.out.println("Introduce un número positivo");
            }
        } while (numeroLeido < 0);

        return numeroLeido;
    }

    /**
     * Lee un entero comprendido entre el mínimo y el máximo (incluidos)
     * @param min Valor mínimo aceptado
     * @param max Valor máximo aceptado
     * @return Devuelve un valor entre el mínimo y máximo
     */
    public static int leerEnteroDeRango(String mensaje, int min, int max){
        if (min >= max){
            // TODO: Hacer cuando conozcamos las excepciones
        }

        System.out.printf(mensaje + ": ");

        int numeroLeido;
        do {
            numeroLeido = Integer.parseInt(sc.nextLine());

            if (numeroLeido> min || numeroLeido < max){
                System.out.printf("Porfavor introduce un valor entre %d y %d", min, max);
            }
        } while (numeroLeido > min || numeroLeido < max);

        return numeroLeido;
    }

    public static char leerSN(String mensaje){
        System.out.printf(mensaje + ": ");

        char sn;

        do {
            sn = sc.nextLine().toUpperCase().charAt(0);
        }while (sn != 'S' && sn != 'N');

        return sn;
    }

    public static void cerrarScanner(){
        sc.close();
    }
}
