package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConvertToJson {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().create();
        Address address = new Address("Lenina", "Tyumen", 625000);
        Student student = new Student("Pavel", 19, new String[]{"mathematics", "physics"}, address, true);
        String studentJson = gson.toJson(student);
        System.out.println(studentJson);
        String studentStr =
                "{"
                        + "\"name\": Sergey,"
                        + "\"course\": 19,"
                        + "\"subjectsStudy\": [\"economics\"],"
                        + "\"address\":"
                        + "{"
                        + "\"street\": \"Mira\","
                        + "\"city\": \"Omsk\","
                        + "\"index\":644000"
                        + "},"
                        + "\"active\": false"
                        + "}";
        Student studentFromStr = gson.fromJson(studentStr, Student.class);
        System.out.println(studentFromStr);
    }
}
