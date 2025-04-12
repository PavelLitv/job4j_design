package ru.job4j.ood.srp.report;

import com.google.gson.GsonBuilder;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.function.Predicate;

public class JsonEngineReport implements Report {
    private final Store store;

    public JsonEngineReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        var library = new GsonBuilder()
                .registerTypeAdapter(Calendar.class, new CalendarSerializerJson())
                .registerTypeAdapter(GregorianCalendar.class, new CalendarSerializerJson())
                .setPrettyPrinting()
                .create();
        return library.toJson(store.findBy(filter));
    }
}
