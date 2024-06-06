package Tema5_Repaso.Ejemplo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Impares {
    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(5);
        lista.add(2);
        lista.add(7);
        lista.add(8);
        lista.add(6);
        lista.add(5);
        lista.add(1);
        lista.add(4);
        lista.add(8);

        Iterator<Integer> i = lista.iterator();

        while (i.hasNext()){
            Integer impar = i.next();
            if (impar % 2 != 0){
                i.remove();
                //lista.remove(impar); // no se puede utilizar porque el remove de lista no funciona si se está recorriendo la lista
            }
        }
    }
}
