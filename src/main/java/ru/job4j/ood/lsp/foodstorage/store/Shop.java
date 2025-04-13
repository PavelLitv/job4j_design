package ru.job4j.ood.lsp.foodstorage.store;

import ru.job4j.ood.lsp.foodstorage.food.Food;

public class Shop extends AbstractStore {
    @Override
    public void add(Food food) {
        double usagePercent = CALCULATOR.getShelfLifeUsagePercent(food);
        if (usagePercent > EXPIRY_PERCENT_25 && usagePercent <= EXPIRY_PERCENT_75) {
            food.setDiscount(DISCOUNT);
            getFoods().add(food);
        }
    }
}
