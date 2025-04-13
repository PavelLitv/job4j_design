package ru.job4j.ood.lsp.foodstorage.store;

import ru.job4j.ood.lsp.foodstorage.food.Food;

public class Trash extends AbstractStore {
    private final static int EXPIRY_PERCENT_FROM = 75;

    @Override
    public void add(Food food) {
        if (getShelfLifeUsagePercent(food) > EXPIRY_PERCENT_FROM) {
            getFoods().add(food);
        }
    }
}
