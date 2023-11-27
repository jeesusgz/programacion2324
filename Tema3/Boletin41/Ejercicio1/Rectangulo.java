package Tema3.Boletin41.Ejercicio1;

public class Rectangulo {
    public static final double MAX_LONGITUD_ANCHO = 20;

    private double longitud;
    private double ancho;

    public static void main(String[] args) {
        Rectangulo r = new Rectangulo(5, 2);
        System.out.printf("El area del rectangulo es %f\n", r.cacularArea());
        System.out.printf("El perímetro del rectángulo es %f\n", r.CalcularPerimetro());
    }

    public Rectangulo(double l, double a) {
        setLongitud(l);
        setAncho(a);
    }

    public double getLongitud() {
        return longitud;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        if (ancho > 0 && ancho < MAX_LONGITUD_ANCHO) {
            this.ancho = ancho;
        } else {
            throw new IllegalArgumentException("El ancho no puede ser 0 o negativo");
        }

    }

    public void setLongitud(double longitud) {
        if (longitud > 0 && longitud < MAX_LONGITUD_ANCHO) {
            this.longitud = longitud;
        } else {

            throw new IllegalArgumentException("La longitud no puede ser 0 o negativa");
        }
    }
    public double CalcularPerimetro (){
        return 2 * longitud + 2 * ancho;
    }
    public double cacularArea (){
        return  longitud * ancho;
    }
}
