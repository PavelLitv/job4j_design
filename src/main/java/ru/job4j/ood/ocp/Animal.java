package ru.job4j.ood.ocp;

public abstract class Animal {
    public abstract void feed();

    private static class AnimalFeeder {
        public void feed(Animal animal) {
            if (animal instanceof Dog) {
                System.out.println("Feeding dog with meat");
            } else if (animal instanceof Cat) {
                System.out.println("Feeding cat with fish");
            } else {
                throw new IllegalArgumentException("Unknown animal");
            }
        }
    }

    /*
    При добавлении нового подкласса Animal придется изменять существующий код AnimalFeeder, что нарушает принцип OCP
    Решение через наследование и абстрактный метод в классе родителе
     */

    private static class Dog extends Animal {
        @Override
        public void feed() {
            System.out.println("Feeding dog with meat");
        }
    }

    private static class Cat extends Animal {
        @Override
        public void feed() {
            System.out.println("Feeding cat with fish");
        }
    }

    private static class NewAnimalFeeder {
        public void feed(Animal animal) {
            animal.feed();
        }
    }
}
