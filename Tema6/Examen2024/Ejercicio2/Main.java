package Tema6.Examen2024.Ejercicio2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {
    /**
     * Fíjate en el archivo productos.xml. Necesitamos reconfigurar su estructura. Para ello:
     * Crea un nuevo archivo productosCategorizados.xml, en el que metas los productos agrupados por categorías.
     * Es decir, habrá un nodo raíz llamado categorías, dentro del mismo, una categoría con un atributo nombre,
     * y dentro de la misma, todos los productos que compartan dicha categoría y que cumplan las siguientes condiciones:
     * Su nombre no debe tener menos de 5 ni más de 45 caracteres. Se permite CUALQUIER carácter, incluidos letras,
     * símbolos, espacios, etc.
     * La descripción debe tener entre 10 y 50 palabras.
     * Debe tener categoría.
     * La categoría deberá desaparecer del elemento producto, pues ahora estarán agrupados bajo un elemento categoría.
     * Los precios vienen indistintamente con un punto o una coma. En el nuevo fichero todos los productos deben tener un punto.
     * Eso no significa que los productos con una coma sean incorrectos.
     * Aquellos productos que no cumplan con algún requisito, deberán ir a otro fichero llamado productosIncompletos.xml.
     * En el mismo, deberás introducir los productos también separados por categorías, igual que el original.
     * Aquellos productos sin categoría deben agruparse bajo una categoría llamada “Sin categoría”.
     *
     * @param args
     */
    public static void main(String[] args) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse("./src/Tema6/Examen2021/productos.xml");
            NodeList categorias = doc.getElementsByTagName("categoria");

            for (int i = 0; i < categorias.getLength(); i++) {
                Element categoria = (Element) categorias.item(i);

                if (categoria.getNodeType() == Node.ELEMENT_NODE) {
                    String nombre = categoria.getElementsByTagName("nombre").item(0).getTextContent();
                    String descripcion = categoria.getElementsByTagName("descripcion").item(0).getTextContent();
                    String categorico = categoria.getElementsByTagName("categoria").item(0).getTextContent();

                }
            }

        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }

    private static void guardarDocumento(Document doc, String nombreFichero) {

    }

    /**
     * Método que clona un elemento de un documento a otro
     *
     * @param doc
     * @param element
     * @return
     */
    private static Element cloneElement(Document doc, Element element) {
        Element nuevoElemento = doc.createElement(element.getTagName());
        for (int i = 0; i < element.getAttributes().getLength(); i++) {
            nuevoElemento.setAttribute(element.getAttributes().item(i).getNodeName(), element.getAttributes().item(i).getNodeValue());
        }
        for (int i = 0; i < element.getChildNodes().getLength(); i++) {
            if (element.getChildNodes().item(i).getNodeType() == Element.ELEMENT_NODE) {
                nuevoElemento.appendChild(cloneElement(doc, (Element) element.getChildNodes().item(i)));
            } else {
                if (!element.getChildNodes().item(i).getTextContent().isBlank())
                    nuevoElemento.appendChild(doc.createTextNode(element.getChildNodes().item(i).getTextContent()));
            }
        }
        return nuevoElemento;
    }
}
