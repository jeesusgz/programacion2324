package Tema4.Boletin52.Ejercicio3;

public class ITunes implements OfflineMusicPlayer{
    @Override
    public void play() {
        load();
        System.out.println("Playing music on iTunes");
    }

    @Override
    public void stop() {
        System.out.println("Stopping music on iTunes");
    }

    @Override
    public void load() {
        System.out.println("Loading music on iTunes");
    }
}
