package ru.job4j.ood.dip;

public class PaymentService {
    public void makePayment(CreditCardPayment payment, double amount) {
        payment.process(amount);
    }

    public interface Payment {
        void process(double amount);
    }

    public class CreditCardPayment implements Payment {
        @Override
        public void process(double amount) {
        }
    }
}
/*
метод makePayment зависит от CreditCardPayment, а не от абстракции Payment
 */
