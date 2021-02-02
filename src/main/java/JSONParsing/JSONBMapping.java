package JSONParsing;

import javax.json.Json;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.config.PropertyNamingStrategy;
import java.util.ArrayList;
import java.util.List;

public class JSONBMapping {


    public static void main(String[] args) {

        mapObject();
        mapGenericColl();

        Address address = new Address("street",50);
        User user = new User(6,"name","asas@as.com", address,"male");
        System.out.println(user);

        JsonbConfig config = new JsonbConfig().withFormatting(true).withPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE );
        Jsonb jsonb = JsonbBuilder.create(config);
        String result = jsonb.toJson(user);

        System.out.println(result);
    }

    public  static  void mapGenericColl(){

        List<Cat> cats =  new ArrayList<>();
        cats.add(new Cat("cat1", 20));
        cats.add(new Cat("dog", 65));

        JsonbConfig config = new JsonbConfig().withFormatting(true);
        Jsonb jsonb = JsonbBuilder.create(config);
        String result = jsonb.toJson(cats);

        System.out.println("Formated Result : \n "+result);

        System.out.println("GENERIC COLLLECTION : ");
        cats = jsonb.fromJson(result, new ArrayList<Cat>(){}.getClass().getGenericSuperclass());

        System.out.println(cats);

    }
    public  static  void mapObject(){

        Cat cat = new Cat("nemo",5);

        Jsonb jsonb = JsonbBuilder.create();
        String result = jsonb.toJson(cat);

        System.out.println("MAPPING OBJECT: ");

        Cat cat1 = jsonb.fromJson(result, Cat.class);
        System.out.println(cat1);
    }



}


