package Tema6.Boletin72.Ejercicio3;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Ejercicio3 {
    public static void main(String[] args) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse("./src/Tema6/Boletin72/Ejercicio3/desayuno.xml");
            NodeList platosBaratos = doc.getElementsByTagName("food");

            double precioBase = 5;

            for (int i = 0; i < platosBaratos.getLength(); i++) {
                Element plato = (Element) platosBaratos.item(i);
                String textoPrecio = plato.getElementsByTagName("price")
                        .item(0)
                        .getTextContent()
                        .replace(",",".");

                double precio = Double.parseDouble(textoPrecio.substring(0, textoPrecio.length() - 1));

                if (precio < precioBase) {
                    System.out.println("Plato barato: " + plato.getElementsByTagName("name").item(0).getTextContent());
                }
            }

            int caloriasBase = 500;

            System.out.println("Platos con menos de " + caloriasBase + " calorías: ");

            for (int i = 0; i < platosBaratos.getLength(); i++) {
                Element plato = (Element) platosBaratos.item(i);
                String textoCalorias = plato.getElementsByTagName("calories")
                        .item(0)
                        .getTextContent();
                int calorias = Integer.parseInt(textoCalorias);

                if (calorias < caloriasBase) {
                    System.out.println(plato.getElementsByTagName("name").item(0).getTextContent());
                }
            }
            System.out.println();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("No se ha podido leer el archivo");
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }
}
