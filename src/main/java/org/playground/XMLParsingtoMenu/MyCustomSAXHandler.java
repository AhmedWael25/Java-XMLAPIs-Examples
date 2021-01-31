package org.playground.XMLParsingtoMenu;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyCustomSAXHandler extends DefaultHandler {

    private MenuBar menuBar ;

    private static  final  String MENU_ITEM = "MenuItem";
    private static  final  String MENU_BAR = "MenuBar";
    private static  final  String MENU = "Menu";

    private String elementString;


    private Menu menu;
    private MenuItem menuItem;

    private boolean match = false;

    public MyCustomSAXHandler() {
        super();
    }

    public MenuBar getMenuBar(){
        return  menuBar;
    }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);

        switch (qName){
            case  MENU_BAR:
                System.out.println("IN MENU BAR");
                menuBar = new MenuBar();
                break;
            case MENU:
                System.out.println("INT MENU ITEM");
                if(attributes.getValue(0) != null){
                    menu = new Menu();
                    menu.setText(attributes.getValue(0));
                    menuBar.getMenus().add(menu);
                    System.out.println("attts: " + attributes.getValue(0));
                }
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
//        super.characters(ch, start, length);

            String str = new String(ch, start, length);
            Pattern p = Pattern.compile("([a-zA-Z0-9]+)");
            Matcher m = p.matcher(str);

            while (m.find()){
                elementString =m.group();
                System.out.println("MAATCHEEER : "+m.group());
            }
        }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
//        System.out.println(qName);

        switch (qName){
            case MENU_ITEM:
                System.out.println("Name2222: "+elementString );
                MenuItem menuItem = new MenuItem(elementString);
                menu.getItems().add(menuItem);
                break;
            }
    }




    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }


}
