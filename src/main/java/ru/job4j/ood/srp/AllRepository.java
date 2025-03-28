package ru.job4j.ood.srp;

import ru.job4j.question.Info;

public class AllRepository {
    public User save(User user) {
        return user;
    }

    public User findById(int id) {
        return null;
    }

    public Info save(Info info) {
        return info;
    }

    public Info findInfoById(int id) {
        return null;
    }
}

/*
Класс AllRepository отвечает за хранение и поиск двух разных сущностей: User и Info.
 */