package JAXBCodeFirstExample;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"streetname", "streetno"})
public class Address {

    private  int streetno;
//    @XmlTransient
    private  String streetname;

    public Address(int streetno, String  streetname) {
        this.streetno = streetno;
        this.streetname = streetname;

    }
    public Address(){}

//    public int getStreetno() {
//        return streetno;
//    }
//
//    public void setStreetno(int streetno) {
//        this.streetno = streetno;
//    }
//
//    public String getStreetname() {
//        return streetname;
//    }
//
//    public void setStreetname(String streetname) {
//        this.streetname = streetname;
//    }


    @Override
    public String toString() {
        return "Address{" +
                "streetno=" + streetno +
                ", streetname='" + streetname + '\'' +
                '}';
    }
}
