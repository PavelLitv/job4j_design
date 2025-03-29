package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.function.Predicate;

public class ItReport implements Report {
    private final Store store;
    private final DateTimeParser<Calendar> parser;
    private final char separator;

    public ItReport(Store store, DateTimeParser<Calendar> parser, char separator) {
        this.store = store;
        this.parser = parser;
        this.separator = separator;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text
                .append("Name").append(separator)
                .append("Hired").append(separator)
                .append("Fired").append(separator)
                .append("Salary").append(separator)
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(separator)
                    .append(parser.parse(employee.getHired())).append(separator)
                    .append(parser.parse(employee.getFired())).append(separator)
                    .append(employee.getSalary()).append(separator)
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
