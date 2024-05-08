package Tema6.Examen2023;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio2 {
    public static void main(String[] args) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();


        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse("./src/Tema6/Examen2023/simpsons.xml");
            NodeList fechas = doc.getElementsByTagName("fecha_emision");

            for (int i = 0; i < fechas.getLength(); i++) {
                Element fecha = (Element) fechas.item(i);
                int year = Integer.parseInt(fecha.getTextContent().substring(fecha.getTextContent().length() - 4));

                if (year > 1992) {
                    System.out.println(((Element) fecha.getParentNode()).getElementsByTagName("nombre").item(0).getTextContent());
                    System.out.println(fecha.getTextContent());
                }
            }

            NodeList capitulos = doc.getElementsByTagName("capitulo");
            Element raiz = doc.getDocumentElement();

            Pattern p = Pattern.compile("\\p{L}+");

            for (int i = 0; i < capitulos.getLength(); i++) {
                Element capitulo = (Element) capitulos.item(i);

                Element sinopsis = (Element) capitulo.getElementsByTagName("sinopsis").item(0);
                Matcher m = p.matcher(sinopsis.getTextContent());

                if (m.results().count() <= 30){
                    raiz.removeChild(capitulo);
                    i--;
                }
            }

            for (int i = 0; i < capitulos.getLength(); i++) {
                Element capitulo = (Element) capitulos.item(i);
                Element sinopsis = (Element) capitulo.getElementsByTagName("sinopsis").item(0);

                String textoSinopsis = sinopsis.getTextContent();
                textoSinopsis = textoSinopsis.replaceAll("(Marge|Homer|Bart|Lisa|Maggie)", "**$1**");
                sinopsis.setTextContent(textoSinopsis);
            }

        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }
}
