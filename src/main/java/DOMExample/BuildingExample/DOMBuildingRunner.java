package DOMExample.BuildingExample;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class DOMBuildingRunner {

    public static void main(String[] args) {
        new DOMBuildingRunner();
    }

    DOMBuildingRunner(){
        try{
            Document doc = getNewDocument();
            populateDoe(doc);
            Element root  = doc.getDocumentElement();
            printXMLRecursively(root);
        }catch (ParserConfigurationException | IOException | SAXException e){
            e.printStackTrace();
        }
    }

    private Document getNewDocument() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.newDocument();
    }

    private void populateDoe(Document doc){
        Element messages = doc.createElement("messages");

        Element message1 = createMsg(doc, "from1", "to1","BOSY1");
        messages.appendChild(message1);
        Element message2 = createMsg(doc, "from2", "to2","BOSY2");
        messages.appendChild(message2);
        Element message3 = createMsg(doc, "from3", "to3","BOSY3");
        messages.appendChild(message3);

        doc.appendChild(messages);
    }

    private Element createMsg(Document doc, String from, String to, String body){
        Element msgEl = doc.createElement("message");
        msgEl.setAttribute("date", LocalDate.now().toString());

        Element fromEl = doc.createElement("from");
        fromEl.setTextContent(from);
        msgEl.appendChild(fromEl);

        Element toEl = doc.createElement("to");
        toEl.setTextContent(to);
        msgEl.appendChild(toEl);

        Element bodyEl = doc.createElement("body");
        bodyEl.setTextContent(body);
        msgEl.appendChild(bodyEl);

        return  msgEl;
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
