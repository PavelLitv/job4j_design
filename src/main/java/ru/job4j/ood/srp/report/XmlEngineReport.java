package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.model.EmployeeListWrapper;
import ru.job4j.ood.srp.store.Store;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.StringWriter;
import java.util.function.Predicate;

public class XmlEngineReport implements Report {
    private final Store store;

    public XmlEngineReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(EmployeeListWrapper.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        StringWriter writer = new StringWriter();
        EmployeeListWrapper wrapper = new EmployeeListWrapper();
        wrapper.setEmployees(store.findBy(filter));
        marshaller.marshal(wrapper, writer);
        return writer.toString();
    }
}
