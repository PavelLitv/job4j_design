package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ConvertByOrgJson {
    public static void main(String[] args) {
        JSONObject jsonAddress = new JSONObject(
                "{"
                        + "\"street\": \"Mira\","
                        + "\"city\": \"Omsk\","
                        + "\"index\":644000"
                        + "}"
        );

        List<String> subjects = new ArrayList<>();
        subjects.add("mathematics");
        subjects.add("physics");
        JSONArray jsonSubjects = new JSONArray(subjects);

        Address address = new Address("Mira", "Omsk", 644000);
        Student student = new Student("Pavel", 19, new String[]{"mathematics", "physics"}, address, true);
        JSONObject jsonStudent = new JSONObject();
        jsonStudent.put("name", student.getName());
        jsonStudent.put("course", student.getCourse());
        jsonStudent.put("isActive", student.getIsActive());
        jsonStudent.put("address", jsonAddress);
        jsonStudent.put("subjects", jsonSubjects);

        System.out.println(jsonStudent);
        System.out.println(new JSONObject(student));

    }
}
