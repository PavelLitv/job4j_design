package ru.job4j.ood.lsp.parking;

import ru.job4j.ood.lsp.parking.vehicle.Car;
import ru.job4j.ood.lsp.parking.vehicle.Truck;
import ru.job4j.ood.lsp.parking.vehicle.Vehicle;

import java.util.Arrays;
import java.util.Objects;

public class CarParkingOperator implements ParkingOperator<Vehicle> {
    private final Parking parking;

    public CarParkingOperator(Parking parking) {
        this.parking = parking;
    }

    @Override
    public void park(Vehicle vehicle) {
        if (isAvailableSpots(vehicle)) {
            var carSpots = parking.getCarSpots();
            int count = 0;
            for (int i = 0; i < carSpots.length && count < vehicle.getSize(); i++) {
                if (carSpots[i] == null) {
                    carSpots[i] = vehicle;
                    count++;
                }
            }
        } else {
            throw new NoAvailableParkingSpotException("No available parking");
        }
    }

    @Override
    public boolean isAvailableSpots(Vehicle vehicle) {
        return getFreeSize() >= vehicle.getSize();
    }

    @Override
    public boolean supports(Vehicle vehicle) {
        return vehicle instanceof Car || vehicle instanceof Truck;
    }

    private Long getFreeSize() {
        return Arrays.stream(parking.getCarSpots())
                .filter(Objects::isNull)
                .count();
    }
}
