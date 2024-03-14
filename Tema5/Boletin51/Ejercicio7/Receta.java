package Tema5.Boletin51.Ejercicio7;

import java.util.*;
import java.util.stream.Stream;

public class Receta implements Comparable<Receta>{
    private String nombreReceta;
    private int tiempoPreparacion;
    Set<Ingrediente> ingredientes;
    List<String> pasos;

    public Receta(String nombreReceta, int tiempoPreparacion) {
        this.nombreReceta = nombreReceta;
        this.tiempoPreparacion = tiempoPreparacion;
        this.ingredientes = new HashSet<>();
        this.pasos = new LinkedList<>();
    }

    public String getNombreReceta() {
        return nombreReceta;
    }

    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public boolean necesitaIngredientes (String nombreIngrediente){
        return ingredientes.stream().anyMatch(a -> a.getNombre().equals(nombreIngrediente));
    }
    public void addIngrediente(Ingrediente ingrediente){
        Iterator<Ingrediente> it = ingredientes.iterator();
        boolean encontrado = false;

        while (it.hasNext() && !encontrado){
            Ingrediente i = it.next();

            if (ingrediente.getNombre().equals(i.getNombre())){
                i.addCantidad(i.getCantidad());
                encontrado = true;
            }
        }
        if (!encontrado){
            ingredientes.add(ingrediente);
        }
    }

    public void removeIngrediente(Ingrediente ingredienteABorrar) throws IngredienteException{
        if (!ingredientes.remove(ingredienteABorrar)){
            throw new IngredienteException("La receta no contiene ese ingrediente");
        }

        Iterator<String> it = pasos.iterator();

        while (it.hasNext()){
            String paso = it.next();

            if (paso.contains(ingredienteABorrar.getNombre())){
                it.remove();
            }
        }
    }

    public void addPasoDetrasDe(String pasoNuevo, String pasoExistente) throws IngredienteException{
        int posPasoExistente = pasos.indexOf(pasoExistente);

        //IndexOf al no contener el objeto devuelve -1
        if (posPasoExistente == -1){
            throw new IngredienteException("La receta no contiene ese paso");
        }

        //añade +1 para que se añada detras del paso existente
        pasos.add(posPasoExistente + 1, pasoNuevo);
    }

    @Override
    public int compareTo(Receta otra) {
        return nombreReceta.compareTo(otra.nombreReceta);
    }
}
