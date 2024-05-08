package Tema6.Examen2021;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

public class Aeropuerto {
    public static void main(String[] args) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try(PrintWriter pw = new PrintWriter("./src/Tema6/Examen2021/vuelos.txt")) {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse("./src/Tema6/Examen2021/aeropuerto.xml");

            NodeList vuelos = doc.getElementsByTagName("vuelo");

            for (int i = 0; i < vuelos.getLength(); i++) {
                Element vuelo = (Element) vuelos.item(i);
                String id = vuelo.getElementsByTagName("id").item(0).getTextContent();
                String codVuelo = vuelo.getElementsByTagName("codigo").item(0).getTextContent();
                String nombreComp = vuelo.getElementsByTagName("compania").item(0).getTextContent();
                String hora = vuelo.getElementsByTagName("hora_salida").item(0).getTextContent();
                String destino = vuelo.getElementsByTagName("destino").item(0).getTextContent();

                String registro = id + ":" + codVuelo + ":" + codVuelo + ":" + nombreComp + ":" + hora + ":" + destino;
                pw.println(registro);
            }

        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error de lectura/escritura");
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

        
    }
}
