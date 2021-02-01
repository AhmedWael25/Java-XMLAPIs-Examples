package SAXExample.TraversingExampleTwo;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class SAXCallBackHandlerStudents extends DefaultHandler {

    private ArrayList<Student> students ;

    private static final String STUDENTS = "Students";
    private static final String STUDENT = "Student";
    private Student student;
    private StringBuilder contents;

    @Override
    public void startDocument() throws SAXException {
        students = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start: "+ qName);
        switch (qName){
            case STUDENTS:
                break;
            case STUDENT:
                student = new Student();
            default:
                contents = new StringBuilder();
                break;
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End: "+ qName);

        if (qName.equals(STUDENTS))
            return;

        if (qName.equals(STUDENT)){
            students.add(student);
            return;
        }

        switch (qName){
            case "name":
                student.setName(contents.toString());
                break;
            case "email":
                student.setEmail(contents.toString());
                break;
            case "phone":
                student.setPhone(contents.toString());
                break;
            case "age":
                int age = Integer.parseInt(contents.toString().trim());
                student.setAge(age);
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Contents : "+String.copyValueOf(ch, start, length).trim());
        if(contents != null){
            contents.append(ch,start,length);
        }
    }

    public  ArrayList<Student> getStudents(){
        return  students;
    }
}
