package code;


import classes.Coche;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class LeerXMLconSAX {
    public static void leerXML(){
        Path p = Path.of("src/resources/concesionario3.xml");
        ArrayList<Coche> cochesXML = new ArrayList<Coche>();
        if (Files.isReadable(p)){//
            SAXParserFactory saxPF=SAXParserFactory.newInstance();
            CocheHandlerClase cocheHandler = new CocheHandlerClase();
            try {//
                SAXParser parser = saxPF.newSAXParser();
                parser.parse(p.toFile(),cocheHandler);
                cochesXML=cocheHandler.getCoches();
                for (Coche c:cochesXML) {
                    System.out.printf(c.getMarca());

                }
            }catch (ParserConfigurationException e){
                throw  new RuntimeException();
            }catch (SAXException e){
                throw new RuntimeException();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
