package Tema4.DeepSpaceConqueror;

public class Material extends Carta{

    private static final int PRECIO_CARTA_MATERIALES = 0;
    public static final int CANTIDAD_MATERIALES_CARTA = 1;

    private TMateriales tipoMaterial;
    public Material(String nombre, String tipoMaterial) throws InvalidValueException {
        super(nombre, PRECIO_CARTA_MATERIALES);

        try{
            this.tipoMaterial = TMateriales.valueOf(tipoMaterial.toUpperCase());
        }catch (IllegalArgumentException e){
            throw new InvalidValueException("Debes introducir un material válido");
        }
    }

    /**
     * @return el tipo de material de la carta
     */
    public TMateriales getMaterial() {
        return tipoMaterial;
    }
}
