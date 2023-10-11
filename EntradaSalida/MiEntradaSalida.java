package EntradaSalida;

import java.util.Scanner;

public class MiEntradaSalida {
    public static Scanner sc = new Scanner(System.in);

    /**
     * Lee un entero comprendido entre el mínimo y el máximo (incluidos)
     * @param min Valor mínimo aceptado
     * @param max Valor máximo aceptado
     * @return
     */
    public static int leerEnteroDeRango(String mensaje, int min, int max){
        if (min >= max){
            // TODO: Hacer cuando conozcamos las excepciones
        }

        System.out.printf(mensaje);

        int numeroLeido;
        do {
            numeroLeido = Integer.parseInt(sc.nextLine());

            if (numeroLeido> min || numeroLeido < max){
                System.out.printf("Porfavor introduce un valor entre %d y %d", min, max);
            }
        } while (numeroLeido > min || numeroLeido < max);

        return numeroLeido;
    }
}
