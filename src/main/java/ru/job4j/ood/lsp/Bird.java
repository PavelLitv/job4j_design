package ru.job4j.ood.lsp;

public class Bird {
    public void fly(int distance) {
        System.out.println("Bird fly at " + distance);
    }

    private static class Falcon extends Bird {
        @Override
        public void fly(int distance) {
            System.out.println("Falcon fly at " + distance);
        }
    }

    private static class Ostrich extends Bird {
        @Override
        public void fly(int distance) {
            throw new UnsupportedOperationException("Ostriches can't fly");
        }
    }
}
// Ostrich не сохраняет контракт базового класса, который подразумевает умение летать.
