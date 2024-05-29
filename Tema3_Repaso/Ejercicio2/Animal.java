package Tema3_Repaso.Ejercicio2;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Animal {
    private int idAnimal;
    private  String nombreAnimal;
    private  AnimalesGranja animalesGranja;
    private String tipoAlimentacion;
    private int edad;
    private int salud;
    private LocalDateTime fecha;

    private List<String> listaRegistroAlimentacion;
    private List<String> listaRegistroChequeos;

    public Animal(int idAnimal, String nombreAnimal, AnimalesGranja animalesGranja, String tipoAlimentacion, int edad, int salud) throws AnimalException {
        this.idAnimal = idAnimal;
        this.nombreAnimal = nombreAnimal;
        this.animalesGranja = animalesGranja;
        this.tipoAlimentacion = tipoAlimentacion;
        setEdad(edad);
        this.salud = salud;
        this.listaRegistroAlimentacion = new ArrayList<>();
        this.listaRegistroChequeos = new ArrayList<>();
        this.fecha = LocalDateTime.now();
    }



    public void registrarAlimentacion() {
        listaRegistroAlimentacion.add("Fecha de Registro: " + getFecha() + ", Tipo de alimento: " + getTipoAlimentacion());
    }
    public void registrarChequeo() {
        listaRegistroAlimentacion.add("Fecha de Registro: " + getFecha() + ", Tipo de alimento: " + getSalud());
    }


    public List<String> getListaRegistroAlimentacion() {
        return listaRegistroAlimentacion;
    }

    public List<String> getListaRegistroChequeos() {
        return listaRegistroChequeos;
    }

    public String getNombreAnimal() {
        return nombreAnimal;
    }

    public String getTipoAlimentacion() {
        return tipoAlimentacion;
    }

    public int getSalud() {
        return salud;
    }

    public int getRegistroIdAnimal() {
        return idAnimal;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setEdad(int edad) throws AnimalException {
        if (edad < 0){
            throw new AnimalException("Edad incorrecta");
        }
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "idAnimal=" + idAnimal +
                ", nombreAnimal='" + nombreAnimal + '\'' +
                ", animalesGranja=" + animalesGranja +
                ", tipoAlimentacion='" + tipoAlimentacion + '\'' +
                ", edad=" + edad +
                ", salud=" + salud +
                ", fecha=" + fecha;
    }
}
