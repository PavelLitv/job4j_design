package ru.job4j.ood.lsp.foodstorage.store;

import ru.job4j.ood.lsp.foodstorage.food.Food;

public class Warehouse extends AbstractStore {
    private final static int EXPIRY_PERCENT_TO = 25;

    @Override
    public void add(Food food) {
        if (getShelfLifeUsagePercent(food) <= EXPIRY_PERCENT_TO) {
            getFoods().add(food);
        }
    }
}
