package Tema3.Boletin44;

public class Ejercicio10 {
    public static void main(String[] args) {
        System.out.println(esDireccionValida("http://www.mariquita3.es"));
    }

    public static boolean esDireccionValida(String direccion){
        String comienzoCorrecto = "http://www";
        //es \\. para elegir el punto porque si pones . coge all string
        String[] direccionDividida = direccion.split("\\.");

        /*for (String s: direccionDividida) {
            System.out.println(s);
        }*/

        //para comprobar que la dirección tenga las tres partes
        if (direccionDividida.length != 3){
            return false;
        }

        //asi coge el principio de la dirección
        if (!comienzoCorrecto.equals(direccionDividida[0])){
            return false;
        }

        //elige la segunda parte despues del . y si contiene espacios la dirección no es válida
        if (direccionDividida[1].contains(" ")){
            return false;
        }

        if (Character.isDigit(direccionDividida[1].charAt(0))){
            return false;
        }

        if (!direccionDividida[2].equals("es") && !direccionDividida[2].equals("com")){
            return false;
        }

        return true;
    }
}
