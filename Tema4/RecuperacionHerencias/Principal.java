package Tema4.RecuperacionHerencias;

public class Principal {
    public static void main(String[] args) {
        try {
            Estacion e1 = new Estacion("Huelva",
                    new SensorViento("d","o","i",true,DireccionActual.N, 21),
                    new SensorHumedad("d","o","i",true, 80, 91),
                    new SensorTemperatura("d","o","i",true, 13.5));
            e1.checkEstacion();
            e1.detectarLluvia();
        } catch (ValorInvalidoException | PredecirException e) {
            System.out.println(e.getMessage());
        }

        try {
           Estacion e2 = new Estacion("Sevilla",
                    new SensorViento("d","o","i",true, DireccionActual.E, 30),
                    new SensorHumedad("d","o","i",true, 71, 78),
                    new SensorTemperatura("d","o","i",true, 7));
            e2.checkEstacion();
            e2.detectarLluvia();
        } catch (ValorInvalidoException | PredecirException e) {
            System.out.println(e.getMessage());;
        }

    }
}
