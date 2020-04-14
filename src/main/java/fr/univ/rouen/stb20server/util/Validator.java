package fr.univ.rouen.stb20server.util;

import java.io.IOException;
import java.io.StringReader;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;
import fr.univ.rouen.stb20server.controllers.PUTController;

/**
 * Validator pour STB
 * @author Yeser GOUMIDI
 */

public class Validator {

    public boolean validate(String stb20) throws StbNotValidException {
        try {
        	
        	SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(PUTController.class.getResource("/xsd/stb20.xsd"));
            javax.xml.validation.Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new StringReader(stb20)));
        
            return true;

        } catch (SAXException exp) {
        	throw new StbNotValidException(exp.getMessage()+exp);
        } catch (IOException exp) {
        	throw new StbNotValidException(exp.getMessage()+exp);
        }
    }
}
