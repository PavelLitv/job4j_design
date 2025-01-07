package ru.job4j.map;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    @Override
    public String toString() {
        return "User{" +
                "name=" + name +
                ", children=" + children +
                ", birthday=" + birthday.getTime() +
                ", hashcode=" + this.hashCode() +
                ", hash=" + (this.hashCode() ^ (hashCode() >>> 16)) +
                ", bucket=" +(this.hashCode() ^ (hashCode() >>> 16)) % 15 +
                '}';
    }

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        Calendar birthday = Calendar.getInstance();
        User user1 = new User("John", 2, birthday);
        User user2 = new User("John", 2, birthday);
        Map<User, Object> users = new HashMap<>();
        users.put(user1, new Object());
        users.put(user2, new Object());
        users.forEach((key, value) -> System.out.println(key + "\n" + value + "\n"));
    }
}
