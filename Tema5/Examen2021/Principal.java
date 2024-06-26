package Tema5.Examen2021;

public class Principal {
    public static void main(String[] args) {
        NetPlease netPlease = new NetPlease();

        try {
            netPlease.annadirTema("COMEDIA");
            netPlease.annadirTema("ACCION");
            netPlease.annadirTema("DRAMA");

            netPlease.addPelicula("COMEDIA", new Pelicula("BAJO EL MISMO TECHO", 2019));

            netPlease.listadoDeTodasPeliculasDeTodosLosTemas();

        } catch (NetPleaseException e) {
            System.err.println(e.getMessage());
        }
    }
}
