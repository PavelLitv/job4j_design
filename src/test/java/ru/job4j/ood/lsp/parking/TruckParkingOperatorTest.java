package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.parking.vehicle.Truck;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TruckParkingOperatorTest {
    @Test
    void whenTruckFitsInTruckSpotThenTruckSpotIsAddedTruck() {
        Parking parking = new Parking(0, 1);
        TruckParkingOperator operator = new TruckParkingOperator(parking);
        Truck truck = new Truck(2);
        operator.park(truck);
        assertThat(parking.getTruckSpots()[0]).isEqualTo(truck);
    }

    @Test
    void whenNoTruckSpotsThenIsAvailableSpotsReturnsFalseAndNoAvailableParkingSpotException() {
        Parking parking = new Parking(0, 0);
        TruckParkingOperator operator = new TruckParkingOperator(parking);
        Truck truck = new Truck(2);
        boolean result = operator.isAvailableSpots(truck);
        assertThat(result).isFalse();
        assertThatThrownBy(() -> operator.park(truck))
                .isInstanceOf(NoAvailableParkingSpotException.class)
                .hasMessage("No available parking");
    }

    @Test
    void whenTruckIsParkedAndIsStillSpotThenThenSecondSpotIsNull() {
        Parking parking = new Parking(0, 2);
        TruckParkingOperator operator = new TruckParkingOperator(parking);
        operator.park(new Truck(2));
        assertThat(parking.getTruckSpots()[1]).isNull();
    }

    @Test
    void whenTruckIsParkedAndNoMoreSpotsThenIsAvailableSpotsReturnsFalseAndNoAvailableParkingSpotException() {
        Parking parking = new Parking(0, 1);
        TruckParkingOperator operator = new TruckParkingOperator(parking);
        Truck truck = new Truck(2);
        operator.park(truck);
        boolean result = operator.isAvailableSpots(truck);
        assertThat(result).isFalse();
        assertThatThrownBy(() -> operator.park(truck))
                .isInstanceOf(NoAvailableParkingSpotException.class)
                .hasMessage("No available parking");
    }
}
