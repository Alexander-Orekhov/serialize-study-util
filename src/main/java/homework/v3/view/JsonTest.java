package homework.v3.view;

import homework.v3.entity.JsonFileClass;
import homework.v3.marshalling.SerializerJSON;


public class JsonTest {

    public static void main(String[] args) {
        JsonFileClass testClass = new JsonFileClassBuilder().getResult();
        SerializerJSON serializerJSON = new SerializerJSON();
        serializerJSON.write(testClass);
        System.out.println(serializerJSON.read());
    }
}
