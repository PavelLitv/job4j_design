package ru.job4j.ood.dip;

public interface OrderStore {
    void add(OnlineOrder onlineOrder);

    OnlineOrder get(int id);

    interface Order {
        void create();
    }

    class OnlineOrder implements Order {
        @Override
        public void create() {
        }
    }
}
/*
 OrderStore зависит от конкретно реализации, а не абстракции в виде интерфейса Order
 */
