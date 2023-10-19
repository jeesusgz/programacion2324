package Tema1.Boletin17;

import EntradaSalida.MiEntradaSalida;

public class Ejercicio2 {
    public static void main(String[] args) {

        int num = MiEntradaSalida.LeerEnteroPositivo("Introduce un número positivo");

        int inverso = reverse(num);

        if (inverso == num){
            System.out.println("ES capicúa");
        }else {
            System.out.println("NO es capicúa");
        }
    }

    public static int reverse(int num){
        int inverso = 0;
        while(num != 0){
            inverso = inverso * 10 + num % 10;
            num /=10;
        }
        return inverso;
    }
}
