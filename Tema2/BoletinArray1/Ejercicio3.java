package Tema2.BoletinArray1;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

      int numPosicion;
      int min = Integer.MIN_VALUE;
      int max = Integer.MAX_VALUE;
      double suma = 0;
      int contMax = 1;
      int contMin = 1;

      do {
          System.out.println("Dime el número de posiciones que tendrá el array");
          numPosicion = sc.nextInt();
      }while (numPosicion < 1);

      //declara el número de posiciones que tiene el array
      int[]  num = new int[numPosicion];

        for (int i = 0; i < numPosicion; i++) {
            System.out.println("Introduce los números");
            num[i] = sc.nextInt();

            if (num[i] >= max){
                contMax++;
            }else {
                max = num[i];
                contMax = 1;
            }

            if (num[i] <= min){
                if (num[i] == min){
                    contMin++;
                }else {
                    min = num[i];
                    contMin = 1;
                }
            }
            suma += num[i];
        }

        System.out.println("El mayor valor es " + max + " se repite " + contMax);
        System.out.println("El menor valor es " + min + " se repite " + contMin);
        System.out.println("La media es " + suma/numPosicion);
    }
}
