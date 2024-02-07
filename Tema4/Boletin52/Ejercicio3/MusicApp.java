package Tema4.Boletin52.Ejercicio3;

public class MusicApp {

    public static void main(String[] args) {
        MusicPlayer[] players = new MusicPlayer[]{new Spotify(), new ITunes(), new MP3Player()};
        MusicApp app = new MusicApp();
        app.startMusic(players);
    }
    public void startMusic(MusicPlayer[] players){
            for (MusicPlayer p : players){
                p.play();
                p.stop();
        }
    }
}
