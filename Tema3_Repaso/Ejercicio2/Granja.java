package Tema3_Repaso.Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Granja {
    private String nombreGranja;
    private List<Animal> listaAnimales;
    private List<Transacciones> listTransacciones;
    private  List<ProductosAgricolas> listaProductosAgricolas;

    public Granja(String nombreGranja) {
        this.nombreGranja = nombreGranja;
        this.listaAnimales = new ArrayList<>();
        this.listaProductosAgricolas = new ArrayList<>();
    }

    public List<Animal> getListaAnimales() {
        return listaAnimales;
    }


    public void addAnimal(int idAnimal, String nombreAnimal, AnimalesGranja animalesGranja, String tipoAlimentacion, int edad, int salud) throws AnimalException {
        Animal a = new Animal(idAnimal,nombreAnimal, animalesGranja, tipoAlimentacion, edad, salud);
        listaAnimales.add(a);
    }

    public void registrarAlimentacion(Animal a){
        for (Animal animal : listaAnimales){
            if (animal.equals(a)){
                animal.registrarAlimentacion();
                System.out.println("Alimentación registrada para " + a.getNombreAnimal());
                return;
            }
        }
        System.out.println("Animal no encontrado: " + a.getNombreAnimal());
    }

    public void checkSaludAnimal(Animal a){
        for (Animal animal : listaAnimales){
            if (animal.equals(a)){
                animal.registrarChequeo();
                System.out.println("Chequeo registrado para " + a.getNombreAnimal());
                return;
            }
        }
        System.out.println("Animal no encontrado: " + a.getNombreAnimal());
    }

    // TODO -> PARTE PRODUCTOS
    public List<ProductosAgricolas> listaProductosAgricolas() {
        return listaProductosAgricolas;
    }

    public void registrarPrecio2(ProductosAgricolas p) {
        for (ProductosAgricolas productosAgricolas : listaProductosAgricolas) {
            if (productosAgricolas.equals(p)) {
                productosAgricolas.registrarPrecio();
                System.out.println("Alimentación registrada para " + p.getNombreProducto());
                return;
            }
        }
        System.out.println("Animal no encontrado: " + p.getNombreProducto());
    }

    public void checkCantidad(ProductosAgricolas p) {
        for (ProductosAgricolas productosAgricolas : listaProductosAgricolas) {
            if (productosAgricolas.equals(p)) {
                p.registrarCantidadDispoble();
                System.out.println("Chequeo registrado para " + p.getNombreProducto());
                return;
            }
        }
        System.out.println("Animal no encontrado: " + p.getNombreProducto());
    }

    public void addProducto(String nombreProducto, Productos tipoProducto, int cantDisponible, double precio) {
        ProductosAgricolas p = new ProductosAgricolas(nombreProducto, tipoProducto, cantDisponible, precio);
        listaProductosAgricolas.add(p);
    }

    public List<ProductosAgricolas> listaProductosDisponible() {
        return listaProductosAgricolas.stream().filter(ProductosAgricolas::isDisponible).toList();
    }
}
