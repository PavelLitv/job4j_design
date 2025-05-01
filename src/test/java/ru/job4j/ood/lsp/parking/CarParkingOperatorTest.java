package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.parking.vehicle.Car;
import ru.job4j.ood.lsp.parking.vehicle.Truck;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Disabled
class CarParkingOperatorTest {
    @Test
    void whenCarFitsInCarSpotThenCarSpotsIsAddedCar() {
        Parking parking = new Parking(1, 0);
        CarParkingOperator operator = new CarParkingOperator(parking);
        Car car = new Car();
        operator.isAvailableSpots(car);
        assertThat(parking.getCarSpots()[0]).isEqualTo(car);
    }

    @Test
    void whenNoCarSpotsThenIsAvailableSpotsReturnsFalseAndNoAvailableParkingSpotException() {
        Parking parking = new Parking(0, 0);
        CarParkingOperator operator = new CarParkingOperator(parking);
        boolean result = operator.isAvailableSpots(new Car());
        assertThat(result).isFalse();
        assertThatThrownBy(() -> operator.park(new Car()))
                .isInstanceOf(NoAvailableParkingSpotException.class)
                .hasMessage("No available parking");
    }

    @Test
    void whenCarIsParkedAndIsStillSpotThenSecondSpotIsNull() {
        Parking parking = new Parking(2, 0);
        CarParkingOperator operator = new CarParkingOperator(parking);
        Car car = new Car();
        operator.park(car);
        assertThat(parking.getCarSpots()[1]).isNull();

    }

    @Test
    void whenCarIsParkedAndNoMoreSpotsThenIsAvailableSpotsReturnsFalse() {
        Parking parking = new Parking(1, 0);
        CarParkingOperator operator = new CarParkingOperator(parking);
        Car car = new Car();
        operator.park(car);
        boolean result = operator.isAvailableSpots(car);
        assertThat(result).isFalse();
    }

    @Test
    void whenTruckFitsInCarSpotThenCarSpotsIsAddedTruck() {
        Parking parking = new Parking(2, 0);
        CarParkingOperator operator = new CarParkingOperator(parking);
        Truck truck = new Truck(2);
        operator.isAvailableSpots(truck);
        assertThat(parking.getCarSpots()[0]).isEqualTo(truck);
    }

    @Test
    void whenTruckTakesUpMoreSpotsThenIsAvailableSpotsReturnsFalseAndNoAvailableParkingSpotException() {
        Parking parking = new Parking(1, 0);
        CarParkingOperator operator = new CarParkingOperator(parking);
        Truck truck = new Truck(2);
        boolean result = operator.isAvailableSpots(truck);
        assertThat(result).isFalse();
        assertThatThrownBy(() -> operator.park(truck))
                .isInstanceOf(NoAvailableParkingSpotException.class)
                .hasMessage("No available parking");
    }
}
