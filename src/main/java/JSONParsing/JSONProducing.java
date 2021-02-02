package JSONParsing;

import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonGeneratorFactory;
import javax.json.stream.JsonParser;
import java.io.*;

public class JSONProducing {


    public static void main(String[] args) throws  IOException{
        generateJSON();
    }


    public  static  void generateJSON() throws IOException {

        JsonGeneratorFactory generatorFactory = Json.createGeneratorFactory(null);
        JsonGenerator gen = generatorFactory.createGenerator(System.out);

        gen.writeStartObject()
                .write("Key1","Val1")
                .write("Key2","Val2")
                .write("Key3","Val3")
                .writeStartArray("myArr");
                    for(int i = 0 ; i <3 ; i++)
                        gen.write("fromLoop"+i);
                gen.writeEnd()
                .writeEnd();
        gen.close();
    }
}
