package JAXBCodeFirstExample;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.FileReader;
import java.io.FileWriter;

public class JAXBCodeFirstRunner {

    public static void main(String[] args) throws Exception {

        JAXBContext jaxbContext = JAXBContext.newInstance(Product.class);

        Product student = new Product(50,"Car",66.76 );
        student.getShippingList().add(new Address(65,"street gamed"));
        student.getShippingList().add(new Address(43,"street msh gamed"));

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(student, System.out);
        marshaller.marshal(student, new FileWriter("products.fxml"));

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Product unmarshalledStudent = (Product) unmarshaller.unmarshal(new FileReader("products.fxml"));
        System.out.println(unmarshalledStudent);
    }
}
