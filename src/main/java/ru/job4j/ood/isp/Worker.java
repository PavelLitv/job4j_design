package ru.job4j.ood.isp;

public interface Worker {
    void work();

    void lunchBreak();

    class Robot implements Worker {
        @Override
        public void work() {
            System.out.println("Robot working");
        }

        @Override
        public void lunchBreak() {
            throw new UnsupportedOperationException("Robots don't go to launch");
        }
    }

    class Engineer implements Worker {
        @Override
        public void work() {
            System.out.println("Engineer working");
        }

        @Override
        public void lunchBreak() {
            System.out.println("Engineers go to launch");
        }
    }
}
/*
Интерфейс Worker нарушает принцип ISP, т.к. классы зависят от методов, которые им не нужны
 */
