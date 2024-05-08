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
import java.util.HashSet;
import java.util.Set;

public class Aeropuerto3 {
    public static void main(String[] args) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse("./src/Tema6/Examen2021/aeropuerto.xml");
            NodeList companias = doc.getElementsByTagName("compania");
            Document doc2 = db.newDocument();
            doc2.appendChild(doc2.createElement("companias"));

            Set<String> nombresCompanias = new HashSet<>();

            for (int i = 0; i < companias.getLength(); i++) {
                String compania = companias.item(i).getTextContent();
                nombresCompanias.add(compania);
            }

            nombresCompanias.stream().forEach(compania -> {
               Element nuevaCompania = doc2.createElement("compania");
               nuevaCompania.setAttribute("nombre", compania);
               doc2.getDocumentElement().appendChild(nuevaCompania);
            });

            File f = new File("./src/Tema6/Examen2021/compañias.xml");

            Transformer transformers = TransformerFactory.newInstance().newTransformer();

            transformers.setOutputProperty(OutputKeys.INDENT, "yes");
            transformers.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            StreamResult results = new StreamResult(f);
            DOMSource sources = new DOMSource(doc2);
            transformers.transform(sources, results);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }

    }
}
