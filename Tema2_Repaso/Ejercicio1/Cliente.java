package Tema2_Repaso.Ejercicio1;

public class Cliente {
    private String nombre;
    private int id;

    private static int contCliente = 1;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.id = contCliente++;
    }


}
