package ru.job4j.ood.dip;

public class YandexMap {
    private final GpsTracker tracker = new GpsTracker();

    public void showCurrentPlace() {
        tracker.getCurrentCoordinates();
    }

    public static class Coordinates {
        public double latitude;
        public double longitude;
    }

    public static class GpsTracker {
        public Coordinates getCurrentCoordinates() {
            return null;
        }
    }

    public static class GlonassTracker {
        public Coordinates getCurrentCoordinates() {
            return null;
        }
    }
}
/*
Причина нарушения принципа DIP в том, что класс YandexMap зависит от реализации класса GpsTracker
 */
