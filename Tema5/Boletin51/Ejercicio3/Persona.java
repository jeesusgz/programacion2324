package Tema5.Boletin51.Ejercicio3;

import java.util.ArrayList;
import java.util.List;

public abstract class Persona {
    private  String nombre;
    private List<Mensaje> bandejaDeEntrada;

    public Persona(String nombre) {
        this.nombre = nombre;
        bandejaDeEntrada = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void enviarMensaje (Persona recepetor, String mensaje) throws MensajeException {
        recepetor.bandejaDeEntrada.add(new Mensaje(this, mensaje));
    }
    public String leerMensajes(){
        StringBuilder mensajes = new StringBuilder();
        for (int i = 0; i < bandejaDeEntrada.size(); i++){
            mensajes.append("Mensaje : ").append(i + 1).append("\n");
        }
        return mensajes.toString();
    }
    public String leerMensajesOrdenados(){
        List<Mensaje> bandejaOrdenada2 = new ArrayList<>(bandejaDeEntrada);
        bandejaOrdenada2.sort(null);

        StringBuilder mensajes = new StringBuilder();
        for (int i = 0; i < bandejaOrdenada2.size(); i++){
            mensajes.append("Mensaje : ").append(i + 1).append(": ").append(bandejaOrdenada2.get(i).toString()).append("\n");
        }
        return mensajes.toString();
    }

    public void borrarMensaje(int num) throws MensajeException{
        try{
            bandejaDeEntrada.remove(num - 1);
        }catch (IndexOutOfBoundsException e){
            throw new MensajeException("No existe ese mensaje");
        }
    }

    public String filtarMensajePorFrase(String frase) throws MensajeException{
        StringBuilder mensajes = new StringBuilder();

//        bandejaDeEntrada.stream().filter(m -> m.getTexto().contains(frase))
//                .forEach(m -> mensajes.append("\n").append(m));

        bandejaDeEntrada.stream().map(m -> m.toString())
                .filter(m -> m.contains(frase))
                .forEach(m -> mensajes.append("\n").append(m));

        if (mensajes.isEmpty()){
            throw new MensajeException("No existen mensajes con esa frase");
        }

        return mensajes.toString();
    }
}
