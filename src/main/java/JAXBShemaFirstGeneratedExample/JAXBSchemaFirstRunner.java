package JAXBShemaFirstGeneratedExample;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.FileReader;
import java.io.FileWriter;

public class JAXBSchemaFirstRunner {


    public static void main(String[] args) throws  Exception{

        JAXBContext jaxbContext = JAXBContext.newInstance("JAXBShemaFirstGeneratedExample");
        Marshaller marshaller = jaxbContext.createMarshaller();
        Unmarshaller unmarshaller =  jaxbContext.createUnmarshaller();

        ObjectFactory objFactory = new ObjectFactory();

        AddressType address = objFactory.createAddressType();
        address.setStreetName("Street Dummy Name");
        address.setStreetNum(456);

        PersonType personType = objFactory.createPersonType();
        personType.setName("Ahmed");
        personType.setPhone("0123234324");
        personType.getAddress().add(address);

        JAXBElement<PersonType> person = objFactory.createPerson(personType);

        marshaller.marshal(person,new FileWriter("person.xml"));

        Object obj = unmarshaller.unmarshal(new FileReader("person.xml"));

        //TODO Ask About this
        if (obj instanceof JAXBElement ){

            JAXBElement<PersonType> jaxbElement =   (JAXBElement<PersonType>) obj;
            PersonType personUnMarshalled = jaxbElement.getValue();

            System.out.println(personUnMarshalled.getName() + "  "+ personUnMarshalled.getPhone() );

            for(AddressType add: personUnMarshalled.getAddress()){
                System.out.println(add.getStreetName() + "  " + add.getStreetNum());
            }
        }

    }

}
