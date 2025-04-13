package ru.job4j.ood.lsp.foodstorage.store;

import ru.job4j.ood.lsp.foodstorage.food.Food;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class ShelfLifeCalculator {
    private final ZoneOffset timeZone = ZoneOffset.UTC;

    public double getShelfLifeUsagePercent(Food food) {
        long duration = food.getExpiryDate().toEpochSecond(timeZone) - food.getCreateDate().toEpochSecond(timeZone);
        long past = LocalDateTime.now().toEpochSecond(timeZone) - food.getCreateDate().toEpochSecond(timeZone);
        return ((double) past / duration) * 100;
    }
}
