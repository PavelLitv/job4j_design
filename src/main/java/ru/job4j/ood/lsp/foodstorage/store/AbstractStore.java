package ru.job4j.ood.lsp.foodstorage.store;

import ru.job4j.ood.lsp.foodstorage.food.Food;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {
    protected final static int DISCOUNT = 20;
    protected final static int EXPIRY_PERCENT_25 = 25;
    protected final static int EXPIRY_PERCENT_75 = 75;
    protected final static ShelfLifeCalculator CALCULATOR = new ShelfLifeCalculator();
    private final List<Food> foods = new ArrayList<>();

    @Override
    public List<Food> getFoods() {
        return foods;
    }
}
