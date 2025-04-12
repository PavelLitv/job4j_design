package ru.job4j.ood.srp.report;

import jakarta.xml.bind.JAXBException;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

class ItReportTest {
    @Test
    public void whenFilterByNameThenGetCorrectReport() throws JAXBException {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Petr", now, now, 100);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker1);
        store.add(worker2);
        char separator = ',';
        Report engine = new ItReport(store, parser, separator);
        StringBuilder expected = new StringBuilder()
                .append("Name").append(separator)
                .append("Hired").append(separator)
                .append("Fired").append(separator)
                .append("Salary").append(separator)
                .append(System.lineSeparator())
                .append(worker2.getName()).append(separator)
                .append(parser.parse(worker2.getHired())).append(separator)
                .append(parser.parse(worker2.getFired())).append(separator)
                .append(worker2.getSalary()).append(separator)
                .append(System.lineSeparator());
        assertThat(engine.generate(employee -> employee.getName().equals("Petr"))).isEqualTo(expected.toString());
    }
}
