create table devices
(
    id    serial primary key,
    name  varchar(255),
    price float
);

create table people
(
    id   serial primary key,
    name varchar(255)
);

create table devices_people
(
    id        serial primary key,
    device_id int references devices (id),
    people_id int references people (id)
);

insert into devices(name, price)
VALUES ('macbook', 1000.99);
insert into devices(name, price)
VALUES ('dell', 800.5);
insert into devices(name, price)
VALUES ('hp', 500.99);
insert into devices(name, price)
VALUES ('gold macbook', 9999.99);

insert into people(name)
values ('Петр');
insert into people(name)
values ('Василий');
insert into people(name)
values ('Инокентий');

insert into devices_people(device_id, people_id)
VALUES (1, 1);
insert into devices_people(device_id, people_id)
VALUES (2, 1);
insert into devices_people(device_id, people_id)
VALUES (4, 1);
insert into devices_people(device_id, people_id)
VALUES (2, 2);
insert into devices_people(device_id, people_id)
VALUES (3, 2);
insert into devices_people(device_id, people_id)
VALUES (3, 3);
insert into devices_people(device_id, people_id)
VALUES (1, 3);

select avg(d.price) as "Средняя цена всех устройств"
from devices d;

select p.name as "Имя пользователя", avg(d.price) as "Средняя цена устройств"
from people p
         join devices_people dp on p.id = dp.people_id
         join devices d on dp.device_id = d.id
group by p.name;

select p.name as "Имя пользователя", avg(d.price) as "Средняя цена устройств"
from people p
         join devices_people dp on p.id = dp.people_id
         join devices d on dp.device_id = d.id
group by p.name
having avg(d.price) > 5000;
