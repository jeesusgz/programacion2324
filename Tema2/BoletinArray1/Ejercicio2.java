package Tema2.BoletinArray1;

public class Ejercicio2 {
    public static void main(String[] args) {
        int[] miArray = {2,3,45,-3,-2,433,45,-4,-6,56};
        int numNegativos = 0;

        for (int i = 0; i < miArray.length; i++) {
            //miArray[i] coger el contenido del array
            if (miArray[i] < 0){
                numNegativos++;
            }
        }

        System.out.println("Los números negativos son " + numNegativos);
    }
}
