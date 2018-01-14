package dt062g.krsa1201.assignment8;

import java.io.File;
import java.rmi.MarshalException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Validator;

/**
 * <h1>File Handler</h1>
 * <p>A class that can read and save files of type xml</p>
 * @author Kristian Sakarisson (krsa1201)
 * @version 1.0
 * @since 20-11-2017
 */
class FileHandler {

    /**
     * <h2>Save to XML</h2>
     * <p>Saves a drawing to an XML file with a specified file name</p>
     * @param drawing The Drawing object to be saved
     * @param fileName Name of the output file
     */
    static public void saveToXML(Drawing drawing, String fileName) {
        if (!fileName.endsWith(".xml")) {
            fileName += ".xml";
        }
        try {
            File file = new File(fileName);
            JAXBContext ctx = JAXBContext.newInstance(Drawing.class);
            Marshaller marshaller = ctx.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(drawing, file);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * <h2>Save to XML</h2>
     * <p>Saves a drawing to an XML file with a determined file name</p>
     * <p>Function simply creates a name and then calls the other saveToXML function</p>
     * @param drawing The Drawing object to be saved
     */
    static public void saveToXML(Drawing drawing) {
        if (drawing.getName().equals("") || drawing.getAuthor().equals("")) {
            System.err.println("Drawing needs author name and title");
            return;
        }
        String fileName = drawing.getName() + " by " + drawing.getAuthor();
        saveToXML(drawing, fileName); //
    }

    /**
     * <h2>Load from XML</h2>
     * <p>Attempt to load a file from a specified file name</p>
     * @param fileName The name of the file to be loaded
     * @return A drawing object
     */
    static public Drawing loadFromXML(String fileName) {
        try {
            if (!fileName.endsWith(".xml")) { // Append filename if .xml if it doens't already end with that
                fileName += ".xml";
            }
            File file = new File(fileName);
            if (!file.exists() || file.isDirectory()) { // Only continue if requested file exists
                return null;
            }
            JAXBContext ctx = JAXBContext.newInstance(Drawing.class);
            Unmarshaller unmarshaller = ctx.createUnmarshaller();
            Drawing drawing = (Drawing) unmarshaller.unmarshal(file);
            return drawing;
        } catch (Exception e) {
            System.err.print(e.getMessage());
        }
        return new Drawing();
    }
}
