package ru.job4j.ood.lsp.foodstorage.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.foodstorage.food.Food;
import ru.job4j.ood.lsp.foodstorage.food.Sugar;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class TrashTest {
    @Test
    void whenExpirationDateIs75PercentThenNotAdded() {
        Food sugar = new Sugar("Сладкий", LocalDateTime.now().plusDays(10), LocalDateTime.now().minusDays(30), 10, 0);
        Trash trash = new Trash();
        trash.add(sugar);
        assertThat(trash.getFoods().size()).isEqualTo(0);
    }

    @Test
    void whenExpirationDateOver75PercentThenAdded() {
        Food sugar = new Sugar("Сладкий", LocalDateTime.now().plusDays(1), LocalDateTime.now().minusDays(30), 10, 0);
        Trash trash = new Trash();
        trash.add(sugar);
        assertThat(trash.getFoods()).containsExactly(sugar);
    }

    @Test
    void whenExpirationDateOver100PercentThenAdded() {
        Food sugar = new Sugar("Сладкий", LocalDateTime.now().minusDays(1), LocalDateTime.now().minusDays(30), 10, 0);
        Trash trash = new Trash();
        trash.add(sugar);
        assertThat(trash.getFoods()).containsExactly(sugar);
    }
}
