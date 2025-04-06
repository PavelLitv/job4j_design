package ru.job4j.ood.ocp;

public class NotificationService {
    public void sendNotification(String type, String message) {
        if ("email".equals(type)) {
            System.out.println("Отправка Email: " + message);
        } else if ("sms".equals(type)) {
            System.out.println("Отправка SMS: " + message);
        }
    }

    /*
    При добавлении нового способа уведомлений придется изменять существующий код, что нарушает принцив OCP
    Решение через интерфейс
     */

    private interface Notifier {
        void notify(String message);
    }

    private static class EmailNotifier implements Notifier {
        public void notify(String message) {
            System.out.println("Отправка Email: " + message);
        }
    }

    private static class SmsNotifier implements Notifier {
        public void notify(String message) {
            System.out.println("Отправка SMS: " + message);
        }
    }

    private static class NewNotificationService {
        public void sendNotification(Notifier notifier, String message) {
            notifier.notify(message);
        }
    }
}
