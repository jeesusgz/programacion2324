package Tema4.RecuperacionHerencias;

public class TermometroInfrarrojos extends SensorTemperatura implements AutoChequeable{

    public TermometroInfrarrojos(String marca, String modelo, String identificador, boolean activo, double gradosCelsius) {
        super(marca, modelo, identificador, activo, gradosCelsius);
    }


    @Override
    public void estado(boolean estado) {
        if (estado){
            System.out.println("Correcto");
        }else {
            System.out.println("Defectuoso");
        }
    }
}
