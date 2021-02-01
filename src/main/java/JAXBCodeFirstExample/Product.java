package JAXBCodeFirstExample;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
@XmlAccessorType(XmlAccessType.FIELD)
public class Product {

    private int id;
    private String name;
    @XmlTransient
    private double price;
    private List<Address> shippingList = new ArrayList<>();

    public Product() { }

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Address> getShippingList() {
        return shippingList;
    }

    public void setShippingList(List<Address> shippingList) {
        this.shippingList = shippingList;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", shippingList=" + shippingList +
                '}';
    }

}
