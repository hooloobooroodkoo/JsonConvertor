package json;

import javax.lang.model.type.NullType;

/**
 * Created by Andrii_Rodionov on 1/4/2017.
 */

public class JsonNull extends Json {
    @Override
    public String toJson() {
        return "null";
    }
}
