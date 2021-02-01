package DOMExample.TraversingExample;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DOMTraversingRunner {

    public static void main(String[] args) {
        new DOMTraversingRunner();
    }

    DOMTraversingRunner(){
        try{
            File file = new File(getClass().getResource("/students.xml").getPath());

            Document doc = getDocumentFromXMLFile(file);
            Element root = doc.getDocumentElement();
            printXMLRecursively(root);

        }catch (ParserConfigurationException | IOException | SAXException e){
            e.printStackTrace();
        }
    }


    private Document getDocumentFromXMLFile(File file) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
        DocumentBuilder parser = factory.newDocumentBuilder();
        return  parser.parse(file);
    }


    private void  printXMLRecursively(Node parent){

        String nodeType = getNodeType(parent.getNodeType());
        System.out.println(parent.getNodeName() + " TYPE:  "+nodeType + "  VAL: "+ parent.getNodeValue());
        NamedNodeMap nodeMap = parent.getAttributes();
        if (nodeMap != null){
            for(int i = 0 ; i <nodeMap.getLength(); i++){
                Node node = nodeMap.item(i);
                System.out.println(node.getNodeName() + "    " + node.getNodeValue());
            }
        }

        NodeList childNodeList = parent.getChildNodes();
        for(int i = 0 ; i < childNodeList.getLength() ; i++){
            Node node = childNodeList.item(i);
            printXMLRecursively(node);
        }
    }


    private String getNodeType(short nodeType){

        switch (nodeType){
            case  Node.ELEMENT_NODE:
                return "element";
            case  Node.ATTRIBUTE_NODE:
                return "attribute";
            case Node.TEXT_NODE:
                return "text";
            case Node.CDATA_SECTION_NODE:
                return "cdata_section";
            case Node.ENTITY_REFERENCE_NODE:
                return "entity_reference";
            case Node.ENTITY_NODE:
                return "entity";
            case Node.PROCESSING_INSTRUCTION_NODE:
                return "processing_instruction";
            case Node.COMMENT_NODE:
                return "comment";

            default:
                return "unknown";
        }
    }



}
