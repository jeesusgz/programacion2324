package Tema6_Repaso.Recuperacion;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Principal {
    public static void main(String[] args) {
        File f = new File("./src/Tema6_Repaso/Recuperacion/files.txt");

        validarCaracter(f);
        interrogacion(f);
    }

    public static void validarCaracter(File f){
        try (BufferedReader br = new BufferedReader(new FileReader(f))){
            String linea;

            Pattern validarCaracter = Pattern.compile("^[?$*]");


            while ((linea = br.readLine()) != null){
                Matcher mCaracter = validarCaracter.matcher(linea);

                if (mCaracter.find()){
                    System.out.println("Carácter válido");
                }else {
                    System.out.println("Carácter inválido");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el fichero");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void interrogacion(File f){
        try(BufferedReader br = new BufferedReader(new FileReader(f))){
            String linea;

            Pattern interrogacion = Pattern.compile("^\\?");
            Pattern validarRuta = Pattern.compile("(([\\w\\d\\.:\\\\\\/]+)(,*[\\w\\d\\.:\\\\\\/]+)*\\|?)");

            while ((linea = br.readLine()) != null){
                Matcher mInterrogacion = interrogacion.matcher(linea);

                if (mInterrogacion.find()){
                    Matcher mRuta = validarRuta.matcher(linea);

                    if (mRuta.find()){
                       if (f.exists()){
                           System.out.println("La ruta existe");
                       }else {
                           System.out.println("La ruta no existe");
                       }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
