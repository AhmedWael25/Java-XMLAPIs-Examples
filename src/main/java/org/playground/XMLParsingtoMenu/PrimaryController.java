package org.playground.XMLParsingtoMenu;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;

public class PrimaryController implements Initializable {


    public BorderPane mainContainer;

   private Document XMLDocument ;

    @Override
    public void initialize(URL location, ResourceBundle resources)  {


        File XMLFile = new File(getClass().getResource("/Menus.xml").getPath());
        Element root = null;
        try {
            XMLDocument = getDocumentFromXMLFile(XMLFile);
            root= XMLDocument.getDocumentElement();
            MenuBar menuBar = populateMenu(root);
            mainContainer.setTop(menuBar);
        }  catch (IOException  | SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }


        System.out.println("========================================");

        MyCustomSAXHandler myCustomSAXHandler = new MyCustomSAXHandler();
        try {
            initSAXParser(XMLFile, myCustomSAXHandler);
            MenuBar menuBar2 = myCustomSAXHandler.getMenuBar();
            mainContainer.setCenter(menuBar2);
        } catch (IOException  | SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }

    }

    private  Document getDocumentFromXMLFile(File file) throws  ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
        DocumentBuilder parser = factory.newDocumentBuilder();
        return  parser.parse(file);
    }


    private void initSAXParser(File file, MyCustomSAXHandler handler) throws IOException, SAXException, ParserConfigurationException{

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(file, handler);
    }

//    private  MenuBar populateMenu2(Element root){
//
//    }

    private MenuBar populateMenu(Element root){
        MenuBar menuBar = new MenuBar();
        NodeList childernList = root.getChildNodes();
        for (int i = 0 ; i < childernList.getLength() ; i++ ){

            Node node = childernList.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE){

                NamedNodeMap atts = node.getAttributes();
                Node att = atts.item(0);

                Menu menu = new Menu(att.getNodeValue());
                NodeList subChildrenList = node.getChildNodes();

                for(int j = 0 ; j < subChildrenList.getLength() ; j ++){

                    Node subNode = subChildrenList.item(j);
                    if(subNode.getNodeType() == Node.ELEMENT_NODE){
                        MenuItem menuItem = new MenuItem(subNode.getTextContent());
                        menu.getItems().add(menuItem);
                    }
                }
                menuBar.getMenus().add(menu);
            }

        }
        return  menuBar;
    }

    private void  printXMLRecursively(Node parent){

//        System.out.println(parent.getNodeName() + "  " + parent.getNodeValue());

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
