package Tema1.Prueba;

public class MetodoVoid {
    public static void main(String[] args) {
        saluda();
        saluda("Mariconaso");
        saluda(55);
        int a = 33;
        saluda(a);
        saluda(suma(a, 9));
    }

    public static void saluda(){
        System.out.println("Hola mundo");
    }
    public static void saluda(String nombre){
        System.out.println("Hola " + nombre);
    }

    public static void saluda(int a){

        System.out.println("Número " + a);
    }

    public static int suma(int a, int b){
        return a + b;
    }
}
