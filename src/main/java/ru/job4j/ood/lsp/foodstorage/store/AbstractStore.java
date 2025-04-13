package ru.job4j.ood.lsp.foodstorage.store;

import ru.job4j.ood.lsp.foodstorage.food.Food;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {
    private final List<Food> foods = new ArrayList<>();
    private final ZoneOffset timeZone = ZoneOffset.UTC;

    @Override
    public List<Food> getFoods() {
        return foods;
    }

    public double getShelfLifeUsagePercent(Food food) {
        long duration = food.getExpiryDate().toEpochSecond(timeZone) - food.getCreateDate().toEpochSecond(timeZone);
        long past = LocalDateTime.now().toEpochSecond(timeZone) - food.getCreateDate().toEpochSecond(timeZone);
        return ((double) past / duration) * 100;
    }
}
