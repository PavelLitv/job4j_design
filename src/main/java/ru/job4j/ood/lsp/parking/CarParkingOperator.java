package ru.job4j.ood.lsp.parking;

import ru.job4j.ood.lsp.parking.vehicle.Vehicle;

public class CarParkingOperator implements ParkingOperator {
    private final Parking parking;

    public CarParkingOperator(Parking parking) {
        this.parking = parking;
    }

    @Override
    public void park(Vehicle vehicle) {

    }

    @Override
    public boolean isAvailableSpots(Vehicle vehicle) {
        return false;
    }
}
