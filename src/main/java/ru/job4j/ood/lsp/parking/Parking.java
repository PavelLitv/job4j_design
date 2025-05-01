package ru.job4j.ood.lsp.parking;

import ru.job4j.ood.lsp.parking.vehicle.Truck;
import ru.job4j.ood.lsp.parking.vehicle.Vehicle;

public class Parking {
    private final Vehicle[] carSpots;
    private final Truck[] truckSpots;

    public Parking(int carSpots, int truckSpots) {
        this.carSpots = new Vehicle[carSpots];
        this.truckSpots = new Truck[truckSpots];
    }

    public Vehicle[] getCarSpots() {
        return carSpots;
    }

    public Truck[] getTruckSpots() {
        return truckSpots;
    }
}
