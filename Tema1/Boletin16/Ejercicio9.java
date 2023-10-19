package Tema1.Boletin16;

public class Ejercicio9 {
    public static void main(String[] args) {
        int tabla = 0;
        int num = 0;

        for (int i = 0; i < 10; i++) {
            num++;
            tabla++;
            System.out.println("La tabla " + tabla );
            for (int j = 0; j <= 10; j++) {
                int resultado = num * j;
                System.out.println(num + " * " + j + " = " + resultado);
            }
        }
    }
}
