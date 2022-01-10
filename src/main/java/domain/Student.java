package domain;

import json.*;

import java.util.ArrayList;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {
    Tuple<String, Integer>[] exams;

    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        super(name, surname, year);
        this.exams = exams;
    }

    @Override
    public JsonObject toJsonObject() {
        JsonPair name_pair = new JsonPair("name", new JsonString(this.name));
        JsonPair surname_pair = new JsonPair("surname", new JsonString(this.surname));
        JsonPair year_pair = new JsonPair("year", new JsonNumber(this.year));
        ArrayList<Json> exams_array = new ArrayList<Json>();
        for (Tuple<String, Integer> json: this.exams) {
            JsonPair course = new JsonPair("course", new JsonString(json.key));
            JsonPair mark = new JsonPair("mark", new JsonNumber(json.value));
            Boolean res;
            if (json.value>2) {
                res = true;
            }
            else {
                res = false;
            }
            JsonPair passing = new JsonPair("passed", new JsonBoolean(res));
            exams_array.add(new JsonObject(course, mark, passing));
        }
        JsonArray arr = new JsonArray(exams_array);
        return new JsonObject(name_pair, surname_pair, year_pair, new JsonPair("exams", arr));
    }
}