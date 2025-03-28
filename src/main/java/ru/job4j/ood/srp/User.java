package ru.job4j.ood.srp;

public class User {
    private String name;
    private int course;

    public User(String name, int course) {
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    public void logging() {
        System.out.println("Student " + name + " is logging");
    }

    public User save() {
        new AllRepository().save(this);
        return this;
    }
}
/*
Класс User не только определяет тип данных, но отвечает за логирование и сохранение данных
 */