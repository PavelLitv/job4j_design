create table customers
(
    id         serial primary key,
    first_name text,
    last_name  text,
    age        int,
    country    text
);

insert into customers(first_name, last_name, age, country)
VALUES ('Sergey', 'Sidorov', 18, 'Russia');
insert into customers(first_name, last_name, age, country)
VALUES ('John', 'Dow', 18, 'USA');
insert into customers(first_name, last_name, age, country)
VALUES ('Santa-Maria', 'luchia', 38, 'Spain');
insert into customers(first_name, last_name, age, country)
VALUES ('Ivan', 'Ivanov', 24, 'Russia');

select *
from customers
where age = (select min(age) from customers);

create table orders
(
    id          serial primary key,
    amount      int,
    customer_id int references customers (id)
);

insert into orders(amount, customer_id)
VALUES (10, 1);
insert into orders(amount, customer_id)
VALUES (1, 3);
insert into orders(amount, customer_id)
VALUES (6, 4);

select *
from customers
where id not in (select customer_id from orders);
