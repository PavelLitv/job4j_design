package ru.job4j.serialization.json;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.StringReader;
import java.io.StringWriter;

public class ConvertXml {
    public static void main(String[] args) throws Exception {
        Address address = new Address("Lenina", "Tyumen", 625000);
        Student student = new Student("Pavel", 19, new String[]{"mathematics", "physics"}, address, true);
        JAXBContext context = JAXBContext.newInstance(Student.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml;
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(student, writer);
            xml = writer.toString();
            System.out.println(xml);
        }

        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Student studentFromXml = (Student) unmarshaller.unmarshal(reader);
            System.out.println(studentFromXml);
        }
    }
}
