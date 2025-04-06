package ru.job4j.ood.ocp;

import java.util.HashMap;
import java.util.Map;

public class DiscountCalculator {
    public double calculateDiscount(String customerType, double amount) {
        return switch (customerType) {
            case "regular" -> amount * 0.05;
            case "vip" -> amount * 0.10;
            case "premium" -> amount * 0.15;
            case null, default -> 0;
        };
    }

    /*
    При добавлении нового типа клиента придется изменять существующий код, что нарушает принцив OCP
    Решение через патерн стратегия
     */

    private interface DiscountStrategy {
        double calculateDiscount(double amount);
    }

    private static class RegularDiscount implements DiscountStrategy {
        @Override
        public double calculateDiscount(double amount) {
            return amount * 0.05;
        }
    }

    private static class VipDiscount implements DiscountStrategy {
        @Override
        public double calculateDiscount(double amount) {
            return amount * 0.10;
        }
    }

    private static class PremiumDiscount implements DiscountStrategy {
        @Override
        public double calculateDiscount(double amount) {
            return amount * 0.15;
        }
    }

    private static class DiscountService {
        private final Map<String, DiscountStrategy> strategies = new HashMap<>();

        public DiscountService() {
            strategies.put("regular", new RegularDiscount());
            strategies.put("vip", new VipDiscount());
            strategies.put("premium", new PremiumDiscount());
        }

        public double calculateDiscount(String customerType, double amount) {
            DiscountStrategy strategy = strategies.getOrDefault(customerType, discount -> 0.00);
            return strategy.calculateDiscount(amount);
        }
    }
}
