package Tema4.DeepSpaceConqueror;

public enum TMateriales {
    PIEDRA, ORO, HIERO, COMBUSTIBLE;


    /**
     * @return un array de string con los nombres de los materiales
     */
    public static String[] getValuesAsString(){
        String[] valores = new String[TMateriales.values().length];
        int i = 0;

        for (TMateriales m : TMateriales.values()){
            valores[i++] = m.toString();
        }

        return valores;
    }
}
