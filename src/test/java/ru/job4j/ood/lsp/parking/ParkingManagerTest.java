package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.parking.vehicle.Car;
import ru.job4j.ood.lsp.parking.vehicle.Truck;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ParkingManagerTest {
    @Test
    void whenParkCarAndNoSpotForCarAndIsSpotForTruckThenNoAvailableParkingSpotException() {
        Parking parking = new Parking(0, 1);
        ParkingManager manager = new ParkingManager(List.of(
                new TruckParkingOperator(parking),
                new CarParkingOperator(parking)
        ));
        assertThatThrownBy(() -> manager.park(new Car()))
                .isInstanceOf(NoAvailableParkingSpotException.class)
                .hasMessage("No available parking");
    }

    @Test
    void whenParkTruckAndNoSpotForCarAndNoSpotForTruckThenNoAvailableParkingSpotException() {
        Parking parking = new Parking(1, 1);
        ParkingManager manager = new ParkingManager(List.of(
                new CarParkingOperator(parking),
                new TruckParkingOperator(parking)
        ));
        Car car = new Car();
        Truck truck = new Truck(2);
        manager.park(car);
        manager.park(truck);
        assertThat(parking.getCarSpots()[0]).isEqualTo(car);
        assertThat(parking.getTruckSpots()[0]).isEqualTo(truck);
    }

    @Test
    void whenTruckParkToCarSpotsThenCarSpotsIsAddedTruck() {
        Parking parking = new Parking(2, 1);
        ParkingManager manager = new ParkingManager(List.of(
                new TruckParkingOperator(parking),
                new CarParkingOperator(parking)
        ));
        Truck truck = new Truck(2);
        Truck truckToCarSpots = new Truck(2);
        manager.park(truck);
        manager.park(truckToCarSpots);
        assertThat(parking.getCarSpots()[0]).isEqualTo(truckToCarSpots);
        assertThat(parking.getTruckSpots()[0]).isEqualTo(truck);
    }
}
