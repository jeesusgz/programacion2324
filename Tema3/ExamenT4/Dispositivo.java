package Tema3.ExamenT4;

public class Dispositivo {
    private String nombre;
    private String conexiones;
    private String protocolosSoportados;

    public Dispositivo(String nombre, String conexiones, String protocolosSoportados) {
        this.nombre = nombre;
        this.conexiones = conexiones;
        this.protocolosSoportados = protocolosSoportados;
    }

    public String getNombre() {
        return nombre;
    }

    public String getConexiones() {
        return conexiones;
    }

    public String getProtocolosSoportados() {
        return protocolosSoportados;
    }
}
