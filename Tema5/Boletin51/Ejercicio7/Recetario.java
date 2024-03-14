package Tema5.Boletin51.Ejercicio7;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class Recetario {
    HashMap<String, Receta> recetas;

    public Recetario() {
        this.recetas = new HashMap<>();
    }

    public void addReceta(Receta nuevaReceta) throws IngredienteException{
        if (recetas.containsKey(nuevaReceta.getNombreReceta())){
            throw new IngredienteException("Ya existe una receta con ese nombre");
        }

        recetas.put(nuevaReceta.getNombreReceta(), nuevaReceta);
    }

    public List<Receta> listaRecetasOrdenadasAlfabeticamente() throws IngredienteException{
        if (recetas.isEmpty()){
            throw new IngredienteException("El recetario esta vacío");
        }

        return recetas.values().stream().sorted().toList();
    }

    public List<Receta> listaRecetasConIngredientesOrdenadasPorTiempoPreparacion(String ingrediente) throws IngredienteException{
        List<Receta> listaRecetas = recetas.values().stream().filter(r -> r.necesitaIngredientes(ingrediente)).toList();

        if (listaRecetas.isEmpty()){
            throw new IngredienteException("No hay recetas con ese ingrediente");
        }

        //a - b se ordena en ascendente y al reves es descendente
        listaRecetas.sort((a, b) -> a.getTiempoPreparacion() - b.getTiempoPreparacion());

        return listaRecetas;
    }
}
