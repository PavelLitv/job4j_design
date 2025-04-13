package ru.job4j.ood.lsp.foodstorage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.foodstorage.food.Bread;
import ru.job4j.ood.lsp.foodstorage.food.Food;
import ru.job4j.ood.lsp.foodstorage.food.Milk;
import ru.job4j.ood.lsp.foodstorage.food.Sugar;
import ru.job4j.ood.lsp.foodstorage.store.Shop;
import ru.job4j.ood.lsp.foodstorage.store.Store;
import ru.job4j.ood.lsp.foodstorage.store.Trash;
import ru.job4j.ood.lsp.foodstorage.store.Warehouse;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ControlQualityTest {
    private final Warehouse warehouse = new Warehouse();
    private final Shop shop = new Shop();
    private final Trash trash = new Trash();
    private final List<Store> stores = List.of(shop, warehouse, trash);
    private final ControlQuality controlQuality = new ControlQuality(stores);

    @AfterEach
    public void afterEach() {
        warehouse.getFoods().clear();
        shop.getFoods().clear();
        trash.getFoods().clear();
    }

    @Test
    void checkTransferFoods() {
        Food bread = new Bread("Бородинский", LocalDateTime.now().plusDays(30), LocalDateTime.now().minusDays(10).plusSeconds(1), 10, 0);
        Food milk = new Milk("Простоквашино", LocalDateTime.now().plusDays(10), LocalDateTime.now().minusDays(30), 10, 0);
        Food sugar = new Sugar("Сладкий", LocalDateTime.now().plusDays(1), LocalDateTime.now().minusDays(30), 10, 0);
        controlQuality.transfer(bread);
        controlQuality.transfer(milk);
        controlQuality.transfer(sugar);
        assertThat(warehouse.getFoods()).containsExactly(bread);
        assertThat(shop.getFoods()).containsExactly(milk);
        assertThat(trash.getFoods()).containsExactly(sugar);
    }

    @Test
    void checkSortFoods() {
        Food bread = new Bread("Бородинский", LocalDateTime.now().plusDays(30), LocalDateTime.now().minusDays(10).plusSeconds(1), 10, 0);
        Food milk = new Milk("Простоквашино", LocalDateTime.now().plusDays(10), LocalDateTime.now().minusDays(30), 10, 0);
        Food sugar = new Sugar("Сладкий", LocalDateTime.now().plusDays(1), LocalDateTime.now().minusDays(30), 10, 0);
        controlQuality.transfer(bread);
        controlQuality.transfer(milk);
        controlQuality.transfer(sugar);

        bread.setExpiryDate(LocalDateTime.now().plusDays(10));
        milk.setExpiryDate(LocalDateTime.now().plusDays(1));
        sugar.setExpiryDate(LocalDateTime.now().minusDays(2));
        controlQuality.sort();

        assertThat(warehouse.getFoods().size()).isEqualTo(0);
        assertThat(shop.getFoods()).containsExactly(bread);
        assertThat(trash.getFoods()).containsExactlyInAnyOrder(sugar, milk);
    }
}
