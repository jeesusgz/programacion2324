package Tema1.Boletin16;

import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num;
        int num2;
        do{
            System.out.println("Introduce un número");
            num = Integer.parseInt(sc.nextLine());

            System.out.println("Introduce un segundo número");
            num2 = Integer.parseInt(sc.nextLine());
        }while(num < 0 || num2 < 0);


        System.out.println("EL MCD de " + num +" y " + num2 + " es " + euclides(num, num2));
    }

    public static int euclides(int num, int num2){
        while(num2 > 0){
            if(num > num2){
                num = num - num2;
            }else {
                num2= num2 - num;
            }
        }
        return num;
    }
}
