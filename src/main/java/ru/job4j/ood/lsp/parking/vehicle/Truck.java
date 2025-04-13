package ru.job4j.ood.lsp.parking.vehicle;

public class Truck extends Vehicle {
    private final int size;

    public Truck(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return this.size;
    }
}
