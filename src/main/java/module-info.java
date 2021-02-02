module org.playground {
    requires javafx.controls;
    requires javafx.fxml;

    requires  java.xml;
    requires jakarta.xml.bind;
    requires java.json;
    requires  java.json.bind;

    opens org.playground.XMLParsingtoMenu to javafx.fxml;
    opens JAXBCodeFirstExample;
    opens JAXBShemaFirstGeneratedExample to jakarta.xml.bind;
    exports org.playground.XMLParsingtoMenu;
    exports JSONParsing to org.eclipse.yasson;
}