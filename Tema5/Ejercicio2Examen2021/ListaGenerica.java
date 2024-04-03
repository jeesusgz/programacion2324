package Tema5.Ejercicio2Examen2021;

import java.util.LinkedList;
import java.util.List;

//Cualquier cosa que herede de T "? super T"
public class ListaGenerica<T extends Comparable<? super T>>{
    private LinkedList<T> lista;

    public ListaGenerica() {
        lista = new LinkedList<>();
    }

    public void addElemento(T elemento){
        lista.add(elemento);
    }

    public ListaGenerica<T> listaHastaElemento(T elementoBuscado){
        ListaGenerica<T> elementosCopiados = new ListaGenerica<>();

        for (T elemento : lista){
            elementosCopiados.addElemento(elemento);
            if (elemento.equals(elementoBuscado)){
                return elementosCopiados;
            }
        }
        return null;
    }

    public ListaGenerica<T> elementosMenores(T elementoReferencia){
        ListaGenerica<T> menores = new ListaGenerica<>();

        for (T elemento : lista){
            if (elemento.compareTo(elementoReferencia) < 0){
                menores.addElemento(elemento);
            }
        }
        return menores.lista.isEmpty() ? null : menores;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ListaGenerica{");
        sb.append("lista=").append(lista);
        sb.append('}');
        return sb.toString();
    }
}
