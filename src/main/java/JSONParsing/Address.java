package JSONParsing;

import javax.json.bind.annotation.JsonbNillable;

@JsonbNillable
public class Address {

    private  String  streetName;
    private  int  streetNum;
    private  String city;

    public    Address(){}

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getStreetNum() {
        return streetNum;
    }

    public void setStreetNum(int streetNum) {
        this.streetNum = streetNum;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Address(String streetName, int streetNum) {
        this.streetName = streetName;
        this.streetNum = streetNum;
    }
}
