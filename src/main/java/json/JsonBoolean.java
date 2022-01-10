package json;

/**
 * Created by Andrii_Rodionov on 1/4/2017.
 */
public class JsonBoolean extends Json {
    private final Boolean aBoolean;
    public JsonBoolean(Boolean bool) {
        this.aBoolean = bool;
    }

    @Override
    public String toJson() {
        return aBoolean.toString();
    }
}
