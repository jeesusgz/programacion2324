package Tema1.Boletin13;

import java.util.Scanner;

public class Ejercicio9 {

    static final int PORCENTAJE_PRODUCTO_A = 7;
    static final int PORCENTAJE_PRODUCTO_C_PRECIO_iNFERIOR = 12;
    static final int RESTO_CASOS = 9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char tipoProducto;
        do {
            System.out.println("Introduce el tipo de producto (A-B-C)");
            tipoProducto = sc.nextLine().charAt(0);

            if (tipoProducto == 'a' || tipoProducto == 'b' || tipoProducto == 'c'){
                break;
            }
        }while (true);

        double precio;
        do {
            System.out.println("Introduce el precio");
            precio = Double.parseDouble(sc.nextLine());
        }while(precio <= 0);

        if (tipoProducto == 'a'){
            double resultado = precio * PORCENTAJE_PRODUCTO_A / 100;
            System.out.printf("Tiene un descuento de %.2f €",(precio - resultado));
        } else if (tipoProducto == 'c' || precio < 500) {
            double resultado = precio * PORCENTAJE_PRODUCTO_C_PRECIO_iNFERIOR / 100;
            System.out.printf("Tiene un descuento de %.2f €",(precio - resultado));
        }else {
            double resultado = precio * RESTO_CASOS / 100;
            System.out.printf("Tiene un descuento de %.2f €",(precio - resultado));
        }
    }
}
