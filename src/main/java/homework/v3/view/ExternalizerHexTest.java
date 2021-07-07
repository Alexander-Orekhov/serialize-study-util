package homework.v3.view;

import homework.v3.entity.JsonFileClass;
import homework.v3.marshalling.ExternalizerHex;

import java.io.*;

public class ExternalizerHexTest {

    public static void main(String[] args) {
        JsonFileClass testClass = new JsonFileClassBuilder().getResult();
        ExternalizerHex serializerHex = new ExternalizerHex();
        serializerHex.setJsonFileClass(testClass);
        System.out.println(testClass);
        try (FileOutputStream fileOutputStream = new FileOutputStream("homework.parameters.exter");
             ObjectOutput objectOutput = new ObjectOutputStream(fileOutputStream)) {
            serializerHex.writeExternal(objectOutput);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonFileClass testClass2 = null;
        try (FileInputStream fileInputStream = new FileInputStream("homework.parameters.exter");
             ObjectInput objectInput = new ObjectInputStream(fileInputStream)) {
            serializerHex.readExternal(objectInput);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        testClass2 = serializerHex.getJsonFileClass();
        System.out.println(testClass2);
    }
}
