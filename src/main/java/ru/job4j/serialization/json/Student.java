package ru.job4j.serialization.json;

import java.util.Arrays;

public class Student {
    private String name;
    private int course;
    private String[] subjectsStudy;
    private Address address;
    private boolean isActive;

    public Student(String name, int course, String[] subjectsStudy, Address address, boolean isActive) {
        this.name = name;
        this.course = course;
        this.subjectsStudy = subjectsStudy;
        this.address = address;
        this.isActive = isActive;
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
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Student{"
                + "name=" + name
                + ", course=" + course
                + ", subjectsStudy=" + Arrays.toString(subjectsStudy)
                + ", address=" + address
                + ", isActive=" + isActive
                + "}";
    }
}
