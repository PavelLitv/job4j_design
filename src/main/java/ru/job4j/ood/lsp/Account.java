package ru.job4j.ood.lsp;

public class Account {
    protected double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Not enough balance");
        }
        balance -= amount;
    }

    private static class OverdraftAccount extends Account {
        public OverdraftAccount(double balance) {
            super(balance);
        }

        @Override
        public void withdraw(double amount) {
            balance -= amount;
        }
    }
}
/*
OverdraftAccount нарушает инвариант базового класса — баланс не должен становиться отрицательным.
 */
