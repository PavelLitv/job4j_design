package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.currency.CurrencyConverter;
import ru.job4j.ood.srp.currency.InMemoryCurrencyConverter;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

class AccountingReportTest {
    @Test
    public void filterBySalaryAndConvertRubToUSDThenGetCorrectReport() {
        CurrencyConverter converter = new InMemoryCurrencyConverter();
        Calendar now = Calendar.getInstance();
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        MemoryStore store = new MemoryStore();
        Employee worker1 = new Employee("Ivan", now, now, 100_000);
        Employee worker2 = new Employee("Ivan", now, now, 200_000);
        Currency source = Currency.RUB;
        Currency target = Currency.USD;
        store.add(worker1);
        store.add(worker2);
        Report engine = new AccountingReport(store, parser, converter, source, target);
        StringBuilder expected = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(" ")
                .append(parser.parse(worker2.getHired())).append(" ")
                .append(parser.parse(worker2.getFired())).append(" ")
                .append(converter.convert(source, worker2.getSalary(), target))
                .append(System.lineSeparator());
        assertThat(engine.generate(employee -> employee.getSalary() > 100_000)).isEqualTo(expected.toString());
    }
}
