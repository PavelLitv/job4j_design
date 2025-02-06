create table customers
(
    id   serial primary key,
    name varchar(255)
);

create table employees
(
    id   serial primary key,
    name varchar(255)
);

create table orders
(
    id           serial primary key,
    summa        int,
    customer_id  int references customers (id),
    employees_id int references customers (id)
);

insert into customers(name)
values ('ООО Рога и копыта');
insert into customers(name)
values ('ООО Меридиан');
insert into customers(name)
values ('ООО ГазМяс');

insert into employees(name)
values ('Павел');
insert into employees(name)
values ('Сергей');
insert into employees(name)
values ('Никита');

insert into orders(summa, customer_id, employees_id)
VALUES (100, 1, 1);
insert into orders(summa, customer_id, employees_id)
VALUES (150, 1, 3);
insert into orders(summa, customer_id, employees_id)
VALUES (50, 2, 2);
insert into orders(summa, customer_id)
VALUES (200, 3);

/* Получить список заказчиков и их заказы */
select c.name "Заказчик", o.summa "Сумма"
from customers c
         join orders o on c.id = o.customer_id;

/* Получить список заказчиков, заказы и работников кто работает с заказом */
select c.name "Заказчик", o.summa "Сумма", e.name "Работник"
from customers c
         join orders o on c.id = o.customer_id
         join employees e on o.employees_id = e.id;

/* Получить заказы с суммой больше 100 и работников кто работает с ними */
select o.summa as "Сумма заказа", e.name as "Имя работника"
from orders o
         join employees e on o.employees_id = e.id
where o.summa > 100;