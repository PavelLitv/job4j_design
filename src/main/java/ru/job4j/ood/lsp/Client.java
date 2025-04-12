package ru.job4j.ood.lsp;

public class Client {
    private final String name;
    private final int age;
    private final String passport;

    public Client(String name, int age, String passport) {
        this.name = name;
        this.age = age;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPassport() {
        return passport;
    }

    private static class AdultClient extends Client {
        public AdultClient(String name, int age, String passport) {
            super(name, age, passport);
        }
    }

    private static class ChildClient extends Client {
        public ChildClient(String name, int age) {
            super(name, age, null);
        }
    }
}
// ChildClient не сохраняет контракт базового класса, который подразумевает наличие паспорта.
