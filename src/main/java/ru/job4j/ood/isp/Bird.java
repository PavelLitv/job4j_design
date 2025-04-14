package ru.job4j.ood.isp;

public interface Bird {
    void eat();

    void fly();

    void swim();

    class Penguin implements Bird {
        @Override
        public void eat() {
            System.out.println("Penguin eat");
        }

        @Override
        public void fly() {
            throw new UnsupportedOperationException("Penguin can not fly");
        }

        @Override
        public void swim() {
            System.out.println("Penguin swim");
        }
    }

    class Sparrow implements Bird {
        @Override
        public void eat() {
            System.out.println("Sparrow eat");
        }

        @Override
        public void fly() {
            System.out.println("Sparrow fly");
        }

        @Override
        public void swim() {
            throw new UnsupportedOperationException("Sparrow can not swim");
        }
    }
}
/*
Интерфейс Bird нарушает принцип ISP, т.к. классы зависят от методов, которые им не нужны
 */
