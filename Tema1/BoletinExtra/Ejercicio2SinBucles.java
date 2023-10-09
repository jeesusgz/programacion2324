package Tema1.BoletinExtra;


public class Ejercicio2SinBucles {
    public static void main(String[] args) {
        System.out.println("La succesión de fibonacci es "+ fibonacci(4));

    }

    public static int fibonacci(int i){
        if(i == 1 || i == 2){
            return 1;
        }

        return fibonacci(i - 1) + fibonacci(i - 2);
    }
}
