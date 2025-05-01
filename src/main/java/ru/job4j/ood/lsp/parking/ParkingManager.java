package ru.job4j.ood.lsp.parking;

import ru.job4j.ood.lsp.parking.vehicle.Vehicle;

import java.util.List;

public class ParkingManager {
    private final List<ParkingOperator> operators;

    public ParkingManager(List<ParkingOperator> operators) {
        this.operators = operators;
    }

    public void park(Vehicle vehicle) {

    }
}
