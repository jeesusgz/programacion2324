package Tema6.Boletin72.Ejercicio2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Ejericio2 {
    public static void main(String[] args) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse("./src/Tema6/Boletin72/Ejercicio2/web1.html");

            Element raiz = doc.getDocumentElement();
            Element titulo = (Element) raiz.getElementsByTagName("title").item(0);

            System.out.println("Título: " + titulo.getTextContent());

            System.out.printf("En la página hay %d divisores\n", raiz.getElementsByTagName("div").getLength());

            NodeList divValores = doc.getElementsByTagName("div");

            int contDivValores = 0;
            for (int i = 0; i < divValores.getLength(); i++) {
                Element element = (Element) divValores.item(i);

                if (!element.getAttribute("id").isBlank()){
                    contDivValores++;
                }
            }

            System.out.printf("En la página hay %d divisores con id\n", contDivValores);

            NodeList img = doc.getElementsByTagName("img");

            for (int i = 0; i < img.getLength(); i++) {
                Element element = (Element) img.item(i);
                if (!element.getAttribute("alt").isBlank()){
                    System.out.println("El atributo alt de la imagen es: " + element.getAttribute("alt"));
                }
            }

            NodeList noticias = doc.getElementsByTagName("div");

            for (int i = 0; i < noticias.getLength(); i++) {
                Node noticia = noticias.item(i);
                if (noticia.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoNoticia = (Element) noticias.item(i);
                    if (elementoNoticia.getAttribute("class").equals("noticia")) {
                        Element titular = (Element) elementoNoticia.getElementsByTagName("h2").item(0);
                        Element imagen = (Element) elementoNoticia.getElementsByTagName("img").item(0);
                        System.out.println("Titular: " + titular.getTextContent());
                        System.out.println("Texto alternativo de la imagen: " + imagen.getAttribute("alt"));
                    }
                }
            }

            NodeList todosLosDiv = doc.getElementsByTagName("div");

            for (int i = 0; i < todosLosDiv.getLength(); i++) {
                Element element = (Element) todosLosDiv.item(i);

                if (element.getAttribute("id").equals("menu-principal")){
                    NodeList liElement = element.getElementsByTagName("li");

                    for (int j = 0; j < liElement.getLength(); j++) {
                        System.out.println("Elemento de la lista: " + liElement.item(j).getTextContent());
                    }
                }
            }

            NodeList todosLosDiv2 = doc.getElementsByTagName("div");

            for (int i = 0; i < todosLosDiv2.getLength(); i++) {
                Element element = (Element) todosLosDiv2.item(i);

                if (element.getAttribute("class").equals("noticia")){
                    String titular = element.getElementsByTagName("h2").item(0).getTextContent();
                    System.out.println("Titular: " + titular);

                    String textoParrafo = element.getElementsByTagName("p").item(0).getTextContent();
                    System.out.println("Texto del párrafo: " + textoParrafo);
                }
            }

        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("No se ha podido abrir el archivo");
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }
}
