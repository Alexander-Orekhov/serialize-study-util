package homework.v3.view;

import homework.v3.entity.Bundle;
import homework.v3.entity.JsonFileClass;
import homework.v3.entity.JsonParameters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonFileClassBuilder {

    JsonFileClass jsonFileClass = new JsonFileClass();

    public JsonFileClass getResult() {
        jsonFileClass.setVersion("1.0");
        buildParameters();
        return jsonFileClass;
    }

    private void buildParameters() {
        ArrayList<JsonParameters> jsonParameters = new ArrayList<>();
        JsonParameters parameters = new ParametersBuilder()
                .buildName("first")
                .buildDescription("some description")
                .buildIsList(true)
                .buildRoles(Arrays.asList(new String[]{"Some roles"}))
                .buildType("Some type")
                .buildBundle(new ArrayList<>())
                .getResult();
        jsonParameters.add(parameters);
        jsonFileClass.setParameters(jsonParameters);
    }


    private class ParametersBuilder {

        JsonParameters jsonParameters = new JsonParameters();

        public ParametersBuilder buildName(String name) {
            jsonParameters.setName(name);
            return this;
        }

        public ParametersBuilder buildDescription(String description) {
            jsonParameters.setDescription(description);
            return this;
        }

        public ParametersBuilder buildIsList(boolean isList) {
            jsonParameters.setList(isList);
            return this;
        }

        public ParametersBuilder buildRoles(List<String> roles) {
            jsonParameters.setRoles(roles);
            return this;
        }

        public ParametersBuilder buildType(String type) {
            jsonParameters.setType(type);
            return this;
        }

        public ParametersBuilder buildBundle(List<Bundle> bundle) {
            jsonParameters.setBundle(bundle);
            return this;
        }

        public JsonParameters getResult() {
            return jsonParameters;
        }

    }
}
