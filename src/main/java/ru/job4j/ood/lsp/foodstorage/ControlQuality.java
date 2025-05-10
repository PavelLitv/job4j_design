package ru.job4j.ood.lsp.foodstorage;

import ru.job4j.ood.lsp.foodstorage.food.Food;
import ru.job4j.ood.lsp.foodstorage.store.Store;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality {
    private final List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void transfer(Food food) {
        stores.forEach(store -> store.add(food));
    }

    public void sort() {
        List<Food> foodsToSort = new ArrayList<>();
        for (Store store : stores) {
            foodsToSort.addAll(store.getFoods());
            store.getFoods().clear();
        }
        foodsToSort.forEach(this::transfer);
    }

    public void resort() {
        sort();
    }
}
