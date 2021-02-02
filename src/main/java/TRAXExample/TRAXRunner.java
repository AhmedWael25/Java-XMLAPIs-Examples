package TRAXExample;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class TRAXRunner {


    public static void main(String[] args) throws Exception {
        new TRAXRunner();
    }

    TRAXRunner() throws Exception {

        File xmlFile = new File(getClass().getResource("/messages.xml").getPath());
//        File htmlFile = new File("messages.html");
//        File transformInst = new File(getClass().getResource("/messages.xslt").getPath());
//        getHTMLFromXML(htmlFile,xmlFile,transformInst);


        XPathTraversing();

        try{
            Document doc = getNewDocument(xmlFile);
            populateDoe(doc);
            domToXMLFile(doc);
        }catch (Exception e){

        }
    }



    private  static  void getHTMLFromXML(File html, File xml, File transf) throws IOException, SAXException, ParserConfigurationException, TransformerException {

        Document xmlDoc = getNewDocument(xml);
        DOMSource xmlDomSource = new DOMSource(xmlDoc);

        Document xsltDoc = getNewNSAwareSoc(transf);
        DOMSource xsltDomSource = new DOMSource(xsltDoc);

        System.out.println(xsltDomSource);

        StreamResult res = new StreamResult(html);

        transformXMLtoHTML(xmlDomSource, xsltDomSource, res);

    }

    private static Document getNewNSAwareSoc(File xsltFile) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder parser = factory.newDocumentBuilder();
        return parser.parse(xsltFile);
    }

    private static Document getNewDocument(File xmlFile) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
        DocumentBuilder parser = factory.newDocumentBuilder();
        return parser.parse(xmlFile);
    }

    private static void transformXMLtoHTML(DOMSource xml, DOMSource xslt, StreamResult res) throws TransformerException {

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer(xslt);
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(xml, res);

    }

    private static void populateDoe(Document doc){
        Element messages = doc.createElement("messages");

        Element message1 = createMsg(doc, "from1", "to1","BOSY1");
        messages.appendChild(message1);
        Element message2 = createMsg(doc, "from2", "to2","BOSY2");
        messages.appendChild(message2);
        Element message3 = createMsg(doc, "from3", "to3","BOSY3");
        messages.appendChild(message3);

        doc.appendChild(messages);
    }

    private static Element createMsg(Document doc, String from, String to, String body){
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

    private static void domToXMLFile(Document doc)throws TransformerException {

        DOMSource source = new DOMSource(doc);

        File outputXMLFile = new File("messages.xml");
        StreamResult res = new StreamResult(outputXMLFile);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(source, res);

    }


    private  void XPathTraversing() throws Exception {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document domDocument = builder.parse(getClass().getResource("/messages.xml").getPath());

        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();
        XPathExpression expression = xPath.compile("//message");

        NodeList nodeList = (NodeList) expression.evaluate(domDocument, XPathConstants.NODESET);//ret obj
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node item = nodeList.item(i);
            System.out.println(item.getTextContent());
        }
    }


}
