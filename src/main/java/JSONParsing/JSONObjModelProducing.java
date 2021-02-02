package JSONParsing;

import javax.json.*;

public class JSONObjModelProducing {

    public static void main(String[] args) {
        produceJSON();
    }

    public static  void produceJSON(){

        JsonBuilderFactory factory = Json.createBuilderFactory(null);
        JsonArrayBuilder arrayBuilder = factory.createArrayBuilder();
        JsonObjectBuilder objectBuilder = factory.createObjectBuilder();

        JsonArray arr = Json.createArrayBuilder()
                .add("ArrEl1")
                .add("ArrEl2")
                .add("ArrEl3").build();

        JsonObject  obj= Json.createObjectBuilder()
                .add("Key1", "Val1")
                .add("MyArr", arr)
                .add("Key2","Val2")
                .build();

        JsonWriter writer = Json.createWriter(System.out);
        writer.writeObject(obj);

    }
}
