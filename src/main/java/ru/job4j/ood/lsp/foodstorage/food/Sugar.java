package ru.job4j.ood.lsp.foodstorage.food;

import java.time.LocalDateTime;

public class Sugar extends Food {
    public Sugar(String name, LocalDateTime expiryDate, LocalDateTime createDate, double price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
