package ru.job4j.ood.lsp.parking;

public class NoAvailableParkingSpotException extends RuntimeException {
    public NoAvailableParkingSpotException(String message) {
        super(message);
    }
}
