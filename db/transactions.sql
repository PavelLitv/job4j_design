create table employees
(
    id     serial primary key,
    name   varchar(255),
    salary int
);

insert into employees(name, salary)
VALUES ('Sergey', 10000);
insert into employees(name, salary)
VALUES ('Pavel', 8500);
insert into employees(name, salary)
VALUES ('Olga', 15000);


set transaction isolation level read committed;

begin;
insert into employees(name, salary)
VALUES ('Ivan', 9000);
update employees
set salary = 10001
where id = 1;
select *
from employees;
commit;

begin transaction isolation level repeatable read;
begin;
insert into employees(name, salary)
VALUES ('Vasiliy', 9000);
select *
from employees;
update employees
set salary = 10002
where id = 1;
select *
from employees;
commit;

begin transaction isolation level serializable;
begin;
update employees
set salary = 10003
where id = 1;
commit;


ROLLBACK;