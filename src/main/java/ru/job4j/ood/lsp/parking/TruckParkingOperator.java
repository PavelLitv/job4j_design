package ru.job4j.ood.lsp.parking;

import ru.job4j.ood.lsp.parking.vehicle.Truck;
import ru.job4j.ood.lsp.parking.vehicle.Vehicle;

import java.util.Arrays;
import java.util.Objects;

public class TruckParkingOperator implements ParkingOperator<Truck> {
    private final Parking parking;

    public TruckParkingOperator(Parking parking) {
        this.parking = parking;
    }

    @Override
    public void park(Truck truck) {
        if (isAvailableSpots(truck)) {
            var truckSpots = parking.getTruckSpots();
            for (int i = 0; i < truckSpots.length; i++) {
                if (truckSpots[i] == null) {
                    truckSpots[i] = truck;
                    break;
                }
            }
        } else {
            throw new NoAvailableParkingSpotException("No available parking");
        }
    }

    @Override
    public boolean isAvailableSpots(Truck truck) {
        return !Arrays.stream(parking.getTruckSpots())
                .filter(Objects::isNull)
                .toList()
                .isEmpty();
    }

    @Override
    public boolean supports(Vehicle vehicle) {
        return vehicle instanceof Truck;
    }
}
