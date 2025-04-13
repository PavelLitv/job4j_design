package ru.job4j.ood.lsp.parking;

import ru.job4j.ood.lsp.parking.vehicle.Vehicle;

public interface ParkingOperator {
    void park(Vehicle vehicle);

    boolean isAvailableSpots(Vehicle vehicle);
}
