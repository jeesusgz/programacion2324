package Tema5.Examen2022.Model;

import Tema5.Examen2022.Exceptions.MazoException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mazo {
    private Map<Cromo, Integer> mazo;

    public Mazo() {
        this.mazo = new HashMap<>();
    }

    /**
     * Añade cromos al mazo
     * @param cromo el cromo a añadir
     * @param numCromos el número de cromos que vas a añadir
     */
    public void addCromo(Cromo cromo, int numCromos){
        //para saber cuantas veces tengo ese cromo
        Integer numPreviosDeUnidades = mazo.get(cromo);

        if (numPreviosDeUnidades == null){
            mazo.put(cromo, numCromos);
        }
        else {
            mazo.replace(cromo, numCromos + numPreviosDeUnidades);
        }
    }

    /**
     * solo se utiliza para compatibilizar en la clase main addCromo
     * @param cromo cromo añadido al mazo
     */
    public void addCromo(Cromo cromo){
        addCromo(cromo, 1);
    }

    /**
     * intercambiar cromos con otra persona
     * @param cromoParaCambiar mi cromo que yo tengo
     * @param cromoDelOtro el cromo que va a intercambiar la otra persona
     * @throws MazoException excepcion por si no tienes el cromo que te solicita la otra persona
     */
    public void intercambiar(Cromo cromoParaCambiar, Cromo cromoDelOtro) throws MazoException {
        if (!mazo.containsKey(cromoParaCambiar)){
            throw new MazoException("No tengo ese cromo para intercambiar");
        }

        Integer numPreviosDeUnidades = mazo.get(cromoParaCambiar);

        if (numPreviosDeUnidades > 1){
            mazo.replace(cromoParaCambiar, numPreviosDeUnidades - 1);
        }
        else {
            mazo.remove(cromoParaCambiar);
        }

        addCromo(cromoDelOtro, 1);
    }

    /**
     * mezclar un mazo con otro
     * @param mazoNuevo el mazo nuevo que vas a mezclar
     */
    public void mezclar(Mazo mazoNuevo){
        for (Map.Entry<Cromo, Integer> entry : mazoNuevo.mazo.entrySet()){
            this.addCromo(entry.getKey(), entry.getValue());
        }
    }

    /**
     * cuenta los cromos diferentes que tenemos de cualquier tipo
     */
    public int contarDiferentes(){
        return mazo.size();
    }

    /**
     * muestra el total de cromos que pertenece a un equipo.
     * @param nombre nombre del equipo.
     * @return una lista de cromos del equipo que ha solicitado.
     */
    public List<Cromo> cromosDeUnEquipo(String nombre){
        return mazo.keySet().stream().filter(c -> c.getEquipo().equals(nombre)).toList();
    }

    /**
     * lo mismo pero con castings
     * @param nombreEquipo nombre del equipo.
     * @return una lista de cromos del equipo que ha solicitado.
     */
    public List<Cromo> cromosDeUnEquipo2(String nombreEquipo){
        return mazo.keySet().stream().filter(c -> {
            if (c instanceof Escudo){
                return ((Escudo)c).getNombre().equals(nombreEquipo);
            } else if (c instanceof Jugador) {
                return ((Jugador)c).getEquipo().equals(nombreEquipo);
            }
            return false;
        }).toList();
    }

    /**
     * La media de altura de los jugadores
     * @param equipo nombre del equipo
     * @return un double con la media de la altura
     */
    public double alturaMedia(String equipo) throws MazoException {
        return cromosDeUnEquipo(equipo).stream().filter(c -> c instanceof Jugador).mapToInt(c -> ((Jugador)c)
                        .getAltura())
                        .average().orElseThrow(() -> new MazoException("No hay jugadores de ese equipo"));
    }
}
