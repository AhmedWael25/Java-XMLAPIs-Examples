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
//        JAXBContext jaxbContext = JAXBContext.newInstance("JAXBShemaFirstGeneratedExample");
        Marshaller marshaller = jaxbContext.createMarshaller();
        Unmarshaller unmarshaller =  jaxbContext.createUnmarshaller();

        ObjectFactory objFactory = new ObjectFactory();

        //Unmarshalling
        //TODO Ask About thhis, why not personType, Why Wrapper
        JAXBElement<PersonType> person = (JAXBElement<PersonType>) unmarshaller.unmarshal(new FileReader("person.xml"));

        System.out.println("Printing Person Contents");
        System.out.println(person.getValue().getName());
        System.out.println(person.getValue().getPhone());
        for(AddressType add: person.getValue().getAddress()){
            System.out.println(add.getStreetName() + "  " + add.getStreetNum());
        }

        person.getValue().setName("Mohamed ALi");
        System.out.println("Updating User Name to: "+person.getValue().getName() );
        System.out.println("Check updated marshalled XML ==>>");

        marshaller.marshal(person, new FileWriter("marshalledPersonType.xml"));

    //Example 2
//        AddressType address = objFactory.createAddressType();
//        address.setStreetName("Street Dummy Name");
//        address.setStreetNum(456);
//
//        PersonType personType = objFactory.createPersonType();
//        personType.setName("Ahmed");
//        personType.setPhone("0123234324");
//        personType.getAddress().add(address);
//
//        JAXBElement<PersonType> person = objFactory.createPerson(personType);
//
//        marshaller.marshal(person,new FileWriter("person.xml"));
//
//        Object obj = unmarshaller.unmarshal(new FileReader("person.xml"));
//
//
//        if (obj instanceof JAXBElement ){
//
//            JAXBElement<PersonType> jaxbElement =   (JAXBElement<PersonType>) obj;
//            PersonType personUnMarshalled = jaxbElement.getValue();
//
//            System.out.println(personUnMarshalled.getName() + "  "+ personUnMarshalled.getPhone() );
//
//            for(AddressType add: personUnMarshalled.getAddress()){
//                System.out.println(add.getStreetName() + "  " + add.getStreetNum());
//            }
//        }

    }

}
