package ru.job4j.ood.lsp.foodstorage.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.foodstorage.food.Food;
import ru.job4j.ood.lsp.foodstorage.food.Milk;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class ShopTest {
    @Test
    void whenExpirationDateIs25PercentThenNotAdded() {
        Food food = new Milk("Простоквашино", LocalDateTime.now().plusDays(30), LocalDateTime.now().minusDays(10), 10, 0);
        Shop shop = new Shop();
        shop.add(food);
        assertThat(shop.getFoods().size()).isEqualTo(0);
    }

    @Test
    void whenExpirationDateBetween25and75ThenAdded() {
        Food milk = new Milk("Простоквашино", LocalDateTime.now().plusDays(30), LocalDateTime.now().minusDays(10).minusSeconds(1), 10, 0);
        Shop shop = new Shop();
        shop.add(milk);
        assertThat(shop.getFoods()).containsExactly(milk);
    }

    @Test
    void whenExpirationDateIs75PercentThenAdded() {
        Food milk = new Milk("Простоквашино", LocalDateTime.now().plusDays(10), LocalDateTime.now().minusDays(30), 10, 0);
        Shop shop = new Shop();
        shop.add(milk);
        assertThat(shop.getFoods()).containsExactly(milk);
    }

    @Test
    void whenExpirationDateOver75PercentThenNotAdded() {
        Food milk = new Milk("Простоквашино", LocalDateTime.now().plusDays(10), LocalDateTime.now().minusDays(40), 10, 0);
        Shop shop = new Shop();
        shop.add(milk);
        assertThat(shop.getFoods().size()).isEqualTo(0);
    }

    @Test
    void whenExpirationDateBetween25and75ThenSetDiscount() {
        Food milk = new Milk("Простоквашино", LocalDateTime.now().plusDays(10), LocalDateTime.now().minusDays(10), 10, 0);
        Shop shop = new Shop();
        shop.add(milk);
        assertThat(shop.getFoods().getFirst().getDiscount()).isEqualTo(20);
    }
}
