package Tema4.Boletin52.Ejercicio1;

public class EsportTournament {
    public static void main(String[] args) {
            FPSGamer fpsPlayer = new FPSGamer();
            MOBAGamer mobaPlayer = new MOBAGamer();
            SportGamer sportsPlayer = new SportGamer();
            Gamer[] players = {fpsPlayer, mobaPlayer, sportsPlayer};
            startTournament(players);
    }

    public static void startTournament(Gamer[] players){
        for (Gamer p : players){
            p.playGame();
        }
    }
}
