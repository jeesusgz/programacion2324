package Tema2.BoletinArray1;

public class Ejercicio1 {
    public static void main(String[] args) {
        int[] miArray = {2,56,3,1,78,9,6,-3,0,187282,1};

        int suma = 0;

        //recorrer la array entera
        for (int i = 0; i < miArray.length; i++) {
            if (i % 2 == 0){
                suma += miArray[i];
            }
        }

        System.out.println("La suma de las posiciones pares es " + suma);
    }
}
