package ru.job4j.ood.lsp.parking;

import ru.job4j.ood.lsp.parking.vehicle.Vehicle;

public interface ParkingOperator<T extends Vehicle> {
    void park(T vehicle);

    boolean isAvailableSpots(T vehicle);
}
