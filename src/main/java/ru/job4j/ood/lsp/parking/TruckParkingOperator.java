package ru.job4j.ood.lsp.parking;

import ru.job4j.ood.lsp.parking.vehicle.Truck;

public class TruckParkingOperator implements ParkingOperator<Truck> {
    private final Parking parking;

    public TruckParkingOperator(Parking parking) {
        this.parking = parking;
    }

    @Override
    public void park(Truck truck) {

    }

    @Override
    public boolean isAvailableSpots(Truck truck) {
        return false;
    }
}
