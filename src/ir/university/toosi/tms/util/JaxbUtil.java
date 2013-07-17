package ir.university.toosi.tms.util;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * @author : Hamed Hatami ,  Farzad Sedaghatbin, Atefeh Ahmadi, Mostafa Rastgar
 * @version : 0.8
 */

public class JaxbUtil {


    public static Object XmlToObject(String xml, String type) throws JAXBException {
        Object result = null;
        StringBuilder domain = new StringBuilder("ir.isc.Aria.ACH.model.entity.");
        switch (type) {
            case "1":
                domain.append("ach00400101");
                break;
            case "2":
                domain.append("ach00800101");
                break;
            case "3":
                domain.append("job");
                break;
            default:
        }
        try {
            JAXBContext jc = JAXBContext.newInstance(domain.toString());
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            result = (Object) unmarshaller.unmarshal(new StreamSource(new StringReader(xml)));
        } catch (JAXBException e) {
            return null;
        }
        return result;
    }

    public static String ObjectToXml(Object object) {

        String result = "";
        StringWriter sw = new StringWriter();

        try {
            JAXBContext jc = JAXBContext.newInstance("ir.isc.Aria.ACH.model.entity");
            Marshaller marshaller = jc.createMarshaller();
            marshaller.marshal(object, sw);
            result = sw.toString();

        } catch (JAXBException e) {
            return null;
        }
        return result;
    }

}