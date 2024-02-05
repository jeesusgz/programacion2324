package Tema4.Boletin51.Ejercicio3;

public class Principal {
    public static void main(String[] args) {
        try {
            Mago magoA = new Mago("Manolo",Raza.ENANO,15, 18, 21);
            Mago magoB = new Mago("Jaimito",Raza.ELFO,12, 18, 19);
            Clerigo clerigo = new Clerigo("Seba", Raza.HUMANO, 19, 14, 23, "Mesi");

            System.out.println(magoA);
            System.out.println(magoB);
            System.out.println(clerigo);

            magoA.aprendeHechizo("transvesti");
            magoA.aprendeHechizo("Mariconazo");
            magoB.aprendeHechizo("puterio");

            System.out.println(magoA);
            System.out.println(magoB);

            magoA.lanzarHechizo(magoB, "Mariconazo");

            System.out.println(magoA);
            System.out.println(magoB);
            System.out.println(clerigo);
        } catch (PersonajeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
