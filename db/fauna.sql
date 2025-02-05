create table fauna
(
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

insert into fauna(name, avg_age, discovery_date) values ('arachnids', 15000, '0001.12.31');
insert into fauna(name, avg_age, discovery_date) values ('mammals', 25000, '0101.12.31');
insert into fauna(name, avg_age, discovery_date) values ('birds', 5000, null);
insert into fauna(name, avg_age, discovery_date) values ('flying fish', 1000, '1980.01.29');

select * from fauna
where name like '%fish%';

select * from fauna
where avg_age >= 10000 and avg_age <= 21000;

select * from fauna
where discovery_date is null;

select * from fauna
where discovery_date < '1950.01.01';