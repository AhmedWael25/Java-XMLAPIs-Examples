package JSONParsing;

import javax.json.*;
import java.io.FileReader;
import java.io.IOException;

public class JSONObjModelConsuming {

    public static void main(String[] args) throws  IOException{
        consumeJSON();
    }

    public  static  void consumeJSON()throws IOException {

        JsonReaderFactory factory = Json.createReaderFactory(null);
        JsonReader JSONReader = factory.createReader(new FileReader("person.json"));
        JsonObject jsonObject = JSONReader.readObject();

        JsonArray jsonArray = jsonObject.getJsonArray("siblings");

        for(JsonValue val :jsonArray){
            System.out.println( val);
        }
    }
}
