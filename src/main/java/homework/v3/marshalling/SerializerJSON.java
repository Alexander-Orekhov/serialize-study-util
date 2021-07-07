package homework.v3.marshalling;

import homework.v3.entity.JsonFileClass;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import java.io.*;

public class SerializerJSON {

    ObjectMapper objectMapper = new ObjectMapper();

    public void write(JsonFileClass object) {
        try {
            objectMapper.writeValue(new File("JsonFileObject.json"), object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JsonFileClass read() {
        JsonFileClass result = null;
        try {
            result = objectMapper.readValue(new File("JsonFileObject.json"), JsonFileClass.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
