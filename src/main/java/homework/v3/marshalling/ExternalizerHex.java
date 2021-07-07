package homework.v3.marshalling;

import homework.v3.entity.JsonFileClass;

import java.io.*;

public class ExternalizerHex implements Externalizable {

    JsonFileClass jsonFileClass;

    public JsonFileClass getJsonFileClass() {
        return jsonFileClass;
    }

    public void setJsonFileClass(JsonFileClass jsonFileClass) {
        this.jsonFileClass = jsonFileClass;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(jsonFileClass);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.jsonFileClass = (JsonFileClass) in.readObject();
    }
}
