package ru.job4j.ood.lsp.foodstorage.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.foodstorage.food.Bread;
import ru.job4j.ood.lsp.foodstorage.food.Food;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class WarehouseTest {
    @Test
    void whenExpirationDateLess25PercentThenAdded() {
        Food bread = new Bread("Бородинский", LocalDateTime.now().plusDays(30), LocalDateTime.now().minusDays(10).plusSeconds(1), 10, 0);
        Warehouse warehouse = new Warehouse();
        warehouse.add(bread);
        assertThat(warehouse.getFoods()).containsExactly(bread);
    }

    @Test
    void whenExpirationDateOver25PercentThenNotAdded() {
        Food bread = new Bread("Бородинский", LocalDateTime.now().plusDays(10), LocalDateTime.now().minusDays(10).minusSeconds(1), 10, 0);
        Warehouse warehouse = new Warehouse();
        warehouse.add(bread);
        assertThat(warehouse.getFoods().size()).isEqualTo(0);
    }

    @Test
    void whenExpirationDateIs25PercentThenAdded() {
        Food bread = new Bread("Бородинский", LocalDateTime.now().plusDays(30), LocalDateTime.now().minusDays(10), 10, 0);
        Warehouse warehouse = new Warehouse();
        warehouse.add(bread);
        assertThat(warehouse.getFoods()).containsExactly(bread);
    }
}
