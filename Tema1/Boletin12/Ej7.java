package Tema1.Boletin12;

import java.util.Scanner;

public class Ej7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce tu tipo de Pokémon favorito(fuego, agua, planta)");
        String pokemon = sc.nextLine();

        if (pokemon.equals("fuego")){
            System.out.println("Charmander");

        } else if (pokemon.equals("agua")) {
            System.out.println("Squirtle");

        } else if (pokemon.equals("planta")) {
            System.out.println("Bulbasaur");
        }else {
            System.out.println("Introduce un tipo de pokemon válido");
        }
    }
}
