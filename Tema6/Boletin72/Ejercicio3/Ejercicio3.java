package Tema6.Boletin72.Ejercicio3;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
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

            for (int i = 0; i < platosBaratos.getLength(); i++) {
                Element plato = (Element) platosBaratos.item(i);
                plato.setAttribute("id", String.valueOf(i + 1));
            }

            Element newElement = doc.createElement("food");
            newElement.setAttribute("id", String.valueOf(platosBaratos.getLength() + 1));
            Element newNombre = doc.createElement("name");
            newNombre.setTextContent("Churros buermu");
            newElement.appendChild(newNombre);
            Element newPrecio = doc.createElement("price");
            newPrecio.setTextContent("1.50€");
            newElement.appendChild(newPrecio);
            Element newCalorias = doc.createElement("calories");
            newCalorias.setTextContent("600");
            newElement.appendChild(newCalorias);
            Element newDescripcion = doc.createElement("description");
            newPrecio.setTextContent("Son unos churros increibles");
            newElement.appendChild(newDescripcion);

            doc.getDocumentElement().appendChild(newElement);

            File f = new File("./src/Tema6/Boletin72/Ejercicio3/desayuno.xml");
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            StreamResult result = new StreamResult(f);
            DOMSource source = new DOMSource(doc);

            transformer.transform(source, result);

            for (int i = 0; i < platosBaratos.getLength(); i++) {
                Element platoMaxCalorias = (Element) platosBaratos.item(i);
                NodeList listaCalorias = platoMaxCalorias.getElementsByTagName("calories");

                if (listaCalorias.getLength() > 0){
                    String textoCalorias = listaCalorias.item(0).getTextContent();

                    if (!textoCalorias.isEmpty()){
                        int calorias = Integer.parseInt(textoCalorias);

                        if (calorias > 500){
                            platoMaxCalorias.getParentNode().removeChild(platoMaxCalorias);
                        }
                    }
                }
            }

            File file = new File("./src/Tema6/Boletin72/Ejercicio3/desayuno.xml");

            Transformer transformers = TransformerFactory.newInstance().newTransformer();

            transformers.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            StreamResult results = new StreamResult(file);

            DOMSource sources = new DOMSource(doc);
            transformer.transform(sources, results);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("No se ha podido leer el archivo");
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }
}
