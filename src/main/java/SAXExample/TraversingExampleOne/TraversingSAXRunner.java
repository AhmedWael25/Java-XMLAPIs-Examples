package SAXExample.TraversingExampleOne;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class TraversingSAXRunner {

    public static void main(String[] args) throws  Exception{

        File XMLFile = new File(TraversingSAXRunner.class.getResource("/Menus.xml").getPath());

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser parser = saxParserFactory.newSAXParser();

        SAXCallBackHandler handler = new SAXCallBackHandler();

        parser.parse(XMLFile, handler);


    }
}
