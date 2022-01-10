package json;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    private HashMap pairs;

    public JsonObject(JsonPair... jsonPairs) {
        pairs = new HashMap();
        for (JsonPair pair : jsonPairs) {
            pairs.put(pair.key, pair.value);

        }
    }

    @Override
    public String toJson() {
        String string = "{";
        if (pairs.isEmpty()){
            return string + "}";
        }
        Set<String> keys = pairs.keySet();
        for (String element: keys) {
            if (pairs.get(element) instanceof String){
                string += element + " : " +  pairs.get(element) + ",";
            }
            else {
                Json json = (Json) pairs.get(element);
                string += element + " : " +  json.toJson() + ",";
            }

        }
        return string.substring(0, string.length() - 1) + "}";
    }

    public void add(JsonPair jsonPair) {
        pairs.put(jsonPair.key, jsonPair.value.toJson());
    }

    public Json find(String name) {
        return (Json) pairs.get(name);
    }

    public JsonObject projection(String... names) {
        JsonObject jsonObj = new JsonObject();
        for (String string: names) {
            if (this.pairs.keySet().contains(string)) {
                jsonObj.add(new JsonPair(string, (Json) pairs.get(string)));
            }
        }
        return jsonObj;
    }
}
