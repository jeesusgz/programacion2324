package Tema3.ExamenT4;

import java.util.Random;

public class Televisor {
    private int width;
    private int Height;
    private String conexiones;
    private String protocolos;
    private String[][] imagen;
    private Imagen colorPromedio;

    public Televisor(int width, int height, String conexiones, String protocolos) {
        this.width = width;
        Height = height;
        this.conexiones = conexiones;
        this.protocolos = protocolos;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return Height;
    }

    public void setImagen(String[][] imagen) {
        this.imagen = imagen;
    }

    public Imagen getColorPromedio() {

        return colorPromedio;
    }

    public boolean isDefectuoso(){
        return false;
    }

    public Dispositivo conectar(Dispositivo dispositivo) throws DispositivoNoCompatibleException{

        String[] conexionesDivididas = conexiones.split(" ");
        String[] protocolosDivididos = protocolos.split(" ");

        if (dispositivo == null){
            throw new DispositivoNoCompatibleException("No hay dispositivo conectado");
        }

        if (!dispositivo.getConexiones().equals(conexionesDivididas[1]) || !conexionesDivididas[2].equals(dispositivo.getConexiones())){
            throw new DispositivoNoCompatibleException("El dispositivo " + dispositivo.getNombre() + " No tiene ninguna conexion compatible");
        }

        if (!dispositivo.getProtocolosSoportados().equals(protocolosDivididos[1].split(" ")) || !protocolosDivididos[2].equals(dispositivo.getProtocolosSoportados()) || !protocolosDivididos[3].equals(dispositivo.getProtocolosSoportados())){
            throw new DispositivoNoCompatibleException("El dispositivo " + dispositivo.getNombre() + " No tiene ningun protocolo compatible");
        }

        return dispositivo;
    }

}
