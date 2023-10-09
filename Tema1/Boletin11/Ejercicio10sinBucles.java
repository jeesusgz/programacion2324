package Tema1.Boletin11;

public class Ejercicio10sinBucles {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    public static int factorial(int a){
        if (a == 0 || a == 1){
            return 1;
        }
        return a * factorial(a - 1);
    }
}
