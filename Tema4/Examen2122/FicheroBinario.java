package Tema4.Examen2122;

public class FicheroBinario extends Fichero{
    private byte[] content;

    /**
     * @param name nombre del ficherp
     * @param content rebice el tamaño en bytes
     */
    public FicheroBinario(String name, byte[] content) {
        super(name, content.length);
        setContent(content);
    }

    public void setContent(byte[] content){
        this.content = content;
    }
}
