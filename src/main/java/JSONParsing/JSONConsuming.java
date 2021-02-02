package JSONParsing;


import javax.json.Json;
import javax.json.stream.JsonParser;
import java.io.FileInputStream;
import java.io.IOException;

public class JSONConsuming {



    public static void main(String[] args) throws  IOException{
        parseJSON();
    }


    public  static  void parseJSON() throws IOException {

        JsonParser parser = Json.createParser(new FileInputStream("person.json"));

        while (parser.hasNext()){
            JsonParser.Event event = parser.next();
            switch (event){
                case KEY_NAME:
                case VALUE_STRING:
                    System.out.println(event);
                    System.out.println(parser.getString());
                    break;
                case START_ARRAY:
                    System.out.println(event);
                    System.out.println(parser.getArray());
                    break;
            }
        }
        parser.close();
    }

}
