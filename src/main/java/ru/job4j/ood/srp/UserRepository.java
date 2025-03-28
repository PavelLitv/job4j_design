package ru.job4j.ood.srp;

public class UserRepository {
    public User saveToDB(User user) {
        return user;
    }

    public User saveToFile(User user) {
        return user;
    }

    public User saveToMap(User user) {
        return user;
    }

    public User getFromDBById(int id) {
        return null;
    }

    public User getFromFileById(int id) {
        return null;
    }

    public User getFromMapById(int id) {
        return null;
    }
}
/*
UserRepository отвечает за три разных способа хранения данных
 */