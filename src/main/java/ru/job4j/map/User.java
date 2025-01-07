package ru.job4j.map;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    @Override
    public String toString() {
        return "User{"
                + "name=" + name
                + ", children=" + children
                + ", birthday=" + birthday.getTime()
                + ", hashcode=" + this.hashCode()
                + ", hash=" + (this.hashCode() ^ (hashCode() >>> 16))
                + ", bucket=" + (this.hashCode() ^ (hashCode() >>> 16)) % 16
                + '}';
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
        Object ob1 = new Object();
        Object ob2 = new Object();
        System.out.println(ob1);
        System.out.println(ob2);
        users.put(user1, ob1);
        users.put(user2, ob2);
        users.forEach((key, value) -> System.out.println(key + "\n" + value + "\n"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children && Objects.equals(name, user.name) && Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }
}
