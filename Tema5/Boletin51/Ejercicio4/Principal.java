package Tema5.Boletin51.Ejercicio4;

import java.util.ArrayList;
import java.util.Iterator;

public class Principal {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);

        reverse(arrayList).stream().forEach(i -> System.out.println(i));
    }

    private static<T> ArrayList<T> reverse (ArrayList<T> arrayOriginal){
        int cont = 0;
        ArrayList<T> arrayNuevo = new ArrayList<T>();

        while (cont < arrayOriginal.size()){
            arrayNuevo.add(arrayOriginal.get(arrayOriginal.size() - 1 - cont));
            cont++;
        }
        return arrayNuevo;
    }
}
