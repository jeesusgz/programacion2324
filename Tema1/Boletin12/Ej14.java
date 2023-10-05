package Tema1.Boletin12;

import java.util.Scanner;

public class Ej14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el primer número");
        int num1 = Integer.parseInt(sc.nextLine());

        System.out.println("Introduce el segundo número");
        int num2 = Integer.parseInt(sc.nextLine());

        System.out.println("Introduce la operación que desea realizar");
        String operacion = sc.nextLine();

        int suma = num1 + num2;
        int resta = num1 - num2;
        int multi = num1 * num2;
        int division = num1 / num2;

        switch(operacion){
            case "suma":
            case "+":
                System.out.println(num1 + " + " + num2 + " = " + suma);
                break;
            case "resta":
            case "-":
                System.out.println(num1 + " - " + num2 + " = " + resta);
                break;
            case "multiplicación":
            case "*":
                System.out.println(num1 + " * " + num2 + " = " + multi);
                break;
            case "división":
            case "/":
                System.out.println((double)num1 + " / " + num2 + " = " + division);
                break;
            default:
                System.out.println("Introduce una operación válida");
        }
    }
}
