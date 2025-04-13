package ru.job4j.ood.lsp.foodstorage.store;

import ru.job4j.ood.lsp.foodstorage.food.Food;

import java.util.List;

public interface Store {
    void add(Food food);

    List<Food> getFoods();
}
