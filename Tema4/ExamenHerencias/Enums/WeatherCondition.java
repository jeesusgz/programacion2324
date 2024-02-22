package Tema4.ExamenHerencias.Enums;

import Tema4.DeepSpaceConqueror.TMateriales;

public enum WeatherCondition {
    LLUVIA, SOL, TORMENTA_ARENA, TORMENTA_ELECTRICA;

    public static String[] getValuesAsString(){
        String[] valores = new String[WeatherCondition.values().length];
        int i = 0;

        for (WeatherCondition w : WeatherCondition.values()){
            valores[i++] = w.toString();
        }

        return valores;
    }
}
