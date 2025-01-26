package ru.job4j.serialization.json;

import jakarta.xml.bind.annotation.*;

import java.util.Arrays;

@XmlRootElement(name = "student")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
    @XmlAttribute
    private String name;
    @XmlAttribute
    private int course;
    @XmlElementWrapper(name = "subjectsStudy")
    @XmlElement(name = "subject")
    private String[] subjectsStudy;
    private Address address;
    @XmlAttribute
    private boolean active;

    public Student() {

    }

    public Student(String name, int course, String[] subjectsStudy, Address address, boolean active) {
        this.name = name;
        this.course = course;
        this.subjectsStudy = subjectsStudy;
        this.address = address;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String[] getSubjectsStudy() {
        return subjectsStudy;
    }

    public void setSubjectsStudy(String[] subjectsStudy) {
        this.subjectsStudy = subjectsStudy;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Student{"
                + "name=" + name
                + ", course=" + course
                + ", subjectsStudy=" + Arrays.toString(subjectsStudy)
                + ", address=" + address
                + ", active=" + active
                + "}";
    }
}
