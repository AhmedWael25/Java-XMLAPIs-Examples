package JSONParsing;

import javax.json.bind.annotation.JsonbNillable;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.json.bind.annotation.JsonbTransient;
import javax.json.bind.config.PropertyOrderStrategy;

@JsonbNillable
@JsonbPropertyOrder(PropertyOrderStrategy.LEXICOGRAPHICAL)
public class User {

    private int id;

    @JsonbProperty("user-name")
    private String name;

    private String email;

    private  Address add;

    @JsonbTransient
    private String  gender;


    public User(int id, String name, String email, Address add, String gender) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.add = add;
        this.gender = gender;
    }

    public Address getAdd() {
        return add;
    }

    public void setAdd(Address add) {
        this.add = add;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


   public User(){}

    public User(int id, String name, String email,String gender) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
    }
}
