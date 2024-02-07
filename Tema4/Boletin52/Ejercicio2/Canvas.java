package Tema4.Boletin52.Ejercicio2;

import java.util.Scanner;

public class Canvas {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Rectangulo r = new Rectangulo() {
            @Override
            int calcularArea() {
                System.out.println("Cuanto tiene de largo: ");
                int lado1 = teclado.nextInt();
                System.out.println("Cuanto tiene de ancho: ");
                int lado2 = teclado.nextInt();
                int resultado = lado1 * lado2;
                return resultado;
            }

            @Override
            public void animar() {
                System.out.println("el rectangulo se esta animando ");
            }

            @Override
            public void dibujar() {
                System.out.println("el rectangulo se esta dibujando ");
            }
        };
        Circulo c = new Circulo() {
            @Override
            int calcularArea() {
                System.out.println("Que radio tiene el circulo: ");
                int radio = teclado.nextInt();
                int resultado = (int) ((radio * radio) * 3.14);
                return resultado;
            }

            @Override
            public void animar() {
                System.out.println("el circulo se esta animando ");
            }

            @Override
            public void dibujar() {
                System.out.println("el circulo se esta dibujando ");
            }

        };
        Forma[] forma = {r, c};
        dibujaYanimaFormas(forma);
    }
    public static void dibujaYanimaFormas(Forma[] forma) {
        for(Forma formas : forma){
            if (formas.comprobacionForma()){
                formas.calcularArea();
                formas.dibujar();
                formas.animar();
            }else {
                System.out.println("esta figura no esta registrada");
            }
        }
    }
}
