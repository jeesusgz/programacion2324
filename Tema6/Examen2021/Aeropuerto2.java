package Tema6.Examen2021;

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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Aeropuerto2 {
    public static void main(String[] args) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try{
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse("./src/Tema6/Examen2021/aeropuerto.xml");
            Document newDoc = db.parse("./src/Tema6/Examen2021/aeropuerto.xml");


            NodeList vuelos = doc.getElementsByTagName("vuelo");

            Pattern p = Pattern.compile("(\\d)(\\d{2})(\\d{3})");


            for (int i = 0; i < vuelos.getLength(); i++) {
                Element vuelo = (Element) vuelos.item(i);
                String id = vuelo.getElementsByTagName("id").item(0).getTextContent();

                Matcher m = p.matcher(id);

                if (m.matches()){
                    String continente = m.group(1);
                    String pais = m.group(2);
                    String aerolinea = m.group(3);
                    String codVuelo = m.group(4);

                    String nuevoId = aerolinea + codVuelo + pais + continente;

                    vuelo.getElementsByTagName("id").item(0).setTextContent(nuevoId);
                    vuelo.removeChild(vuelo.getElementsByTagName("compania").item(0));
                }
            }

            //borrar elementos de xml
            newDoc.appendChild(newDoc.importNode(doc.getDocumentElement(), true));
            NodeList companias = newDoc.getElementsByTagName("compania");

            for (int i = 0; i < companias.getLength(); i++) {
                companias.item(i).getParentNode().removeChild(companias.item(i));
                i--;
            }

            //crear un nuevo xml
            File f = new File("./src/Tema6/Examen2021/aeropuerto2.xml");

            Transformer transformers = TransformerFactory.newInstance().newTransformer();

            transformers.setOutputProperty(OutputKeys.INDENT, "yes");
            transformers.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            StreamResult results = new StreamResult(f);

            DOMSource sources = new DOMSource(doc);
            transformers.transform(sources, results);


        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error de lectura/escritura");
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }
}
