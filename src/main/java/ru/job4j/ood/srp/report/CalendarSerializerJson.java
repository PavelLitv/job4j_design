package ru.job4j.ood.srp.report;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarSerializerJson implements JsonSerializer<Calendar> {
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm");

    @Override
    public JsonElement serialize(Calendar src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(SIMPLE_DATE_FORMAT.format(src.getTime()));
    }
}
