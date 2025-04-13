package ru.job4j.ood.lsp.foodstorage.store;

import ru.job4j.ood.lsp.foodstorage.food.Food;

public class Shop extends AbstractStore {
    private final static int EXPIRY_PERCENT_FROM = 25;
    private final static int EXPIRY_PERCENT_TO = 75;
    private final static int DISCOUNT = 20;

    @Override
    public void add(Food food) {
        double usagePercent = getShelfLifeUsagePercent(food);
        if (usagePercent > EXPIRY_PERCENT_FROM && usagePercent <= EXPIRY_PERCENT_TO) {
            food.setDiscount(DISCOUNT);
            getFoods().add(food);
        }
    }
}
