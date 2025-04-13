package ru.job4j.ood.lsp.foodstorage.store;

import ru.job4j.ood.lsp.foodstorage.food.Food;

public class Warehouse extends AbstractStore {
    @Override
    public void add(Food food) {
        if (CALCULATOR.getShelfLifeUsagePercent(food) <= EXPIRY_PERCENT_25) {
            getFoods().add(food);
        }
    }
}
