package ru.job4j.serialization.json;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "address")
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {
    @XmlAttribute
    private String street;
    @XmlAttribute
    private String city;
    @XmlAttribute
    private int index;

    public Address() {

    }

    public Address(String street, String city, int index) {
        this.street = street;
        this.city = city;
        this.index = index;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "Address{"
                + "street=" + street
                + ", city=" + city
                + ", index=" + index
                + "}";
    }
}
