module org.playground {
    requires javafx.controls;
    requires javafx.fxml;

    requires  java.xml;

    opens org.playground.XMLParsingtoMenu to javafx.fxml;
    exports org.playground.XMLParsingtoMenu;
}