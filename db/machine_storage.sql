/*          1       */
create table car_bodies
(
    id   serial primary key,
    name varchar(255)
);

create table car_engines
(
    id   serial primary key,
    name varchar(255)
);

create table car_transmissions
(
    id   serial primary key,
    name varchar(255)
);

create table car
(
    id              serial primary key,
    name            varchar(255),
    body_id         int references car_bodies (id),
    engine_id       int references car_engines (id),
    transmission_id int references car_transmissions (id)
);

insert into car_bodies(name)
values ('pickup');
insert into car_bodies(name)
values ('bus');
insert into car_bodies(name)
values ('sedan');
insert into car_bodies(name)
values ('coupe');
insert into car_bodies(name)
values ('jeep');
insert into car_bodies(name)
values ('van');

insert into car_engines(name)
values ('P4');
insert into car_engines(name)
values ('P4T');
insert into car_engines(name)
values ('V6');
insert into car_engines(name)
values ('V6T');
insert into car_engines(name)
values ('W12');

insert into car_transmissions(name)
values ('5A');
insert into car_transmissions(name)
values ('5M');
insert into car_transmissions(name)
values ('7A');

insert into car(name, body_id, engine_id, transmission_id)
VALUES ('Corolla', 3, 1, 1);
insert into car(name, body_id, engine_id, transmission_id)
VALUES ('Hilux', 1, 2, 2);
insert into car(name, body_id, engine_id, transmission_id)
VALUES ('Land Cruiser', 5, 3, 2);
insert into car(name, body_id, engine_id, transmission_id)
VALUES ('Alphroad', 6, 3, 1);
insert into car(name, body_id, engine_id, transmission_id)
VALUES ('feature', 6, null, 1);
insert into car(name)
VALUES ('dream');

/*          2       */
select c.id, c.name, cb.name, ce.name, ct.name
from car c
         left join car_bodies cb on cb.id = c.body_id
         left join car_engines ce on ce.id = c.engine_id
         left join car_transmissions ct on ct.id = c.transmission_id;

select cb.id, cb.name
from car_bodies cb
         left join car c on cb.id = c.body_id
where c.body_id is null;

select ce.id, ce.name
from car_engines ce
         left join car c on ce.id = c.engine_id
where c.engine_id is null;

select ct.id, ct.name
from car_transmissions ct
         left join car c on ct.id = c.transmission_id
where c.transmission_id is null;
