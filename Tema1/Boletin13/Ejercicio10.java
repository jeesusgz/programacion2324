package Tema1.Boletin13;

import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un número");
        int num = Integer.parseInt(sc.nextLine());

        System.out.println("Introduce un segundo número");
        int num2 = Integer.parseInt(sc.nextLine());

        char operador;
        do {
            System.out.println("Introduce un operador");
            operador = sc.nextLine().charAt(0);

            if (operador == '+' || operador == '-' || operador == '*' || operador == '/'){
                break;
            }
        }while (true);

        switch (operador){
            case '+':
                System.out.println("El resultado es " + (num + num2));
                break;
            case '-':
                System.out.println("El resultado es " + (num - num2));
                break;
            case '*':
                System.out.println("El resultado es " + (num * num2));
                break;
            case '/':
                if (num2 != 0){
                    System.out.println("El resultado es " + ((double)num / num2));
                }
                break;
            default:
                System.out.println("introduce un operador válido");
        }
    }
}
