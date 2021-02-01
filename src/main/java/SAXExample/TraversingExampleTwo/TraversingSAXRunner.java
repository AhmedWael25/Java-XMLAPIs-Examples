package SAXExample.TraversingExampleTwo;

import SAXExample.TraversingExampleOne.SAXCallBackHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TraversingSAXRunner {


    public static void main(String[] args) throws  Exception{

        File XMLFile = new File(SAXExample.TraversingExampleOne.TraversingSAXRunner.class.getResource("/students.xml").getPath());

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser parser = saxParserFactory.newSAXParser();

        SAXCallBackHandlerStudents handler = new SAXCallBackHandlerStudents();

        parser.parse(XMLFile, handler);

        ArrayList<Student> students = handler.getStudents();

        System.out.println("Number of students: "+students.size());
        for (Student std : students){
            System.out.println("student : " + std);
        }

    }

}
