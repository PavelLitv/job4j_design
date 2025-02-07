/*          1       */
create table departments
(
    id   serial primary key,
    name varchar(255)
);

create table employees
(
    id            serial primary key,
    name          varchar(255),
    department_id int references departments (id)
);

insert into departments(name)
values ('it');
insert into departments(name)
values ('economic');
insert into departments(name)
values ('sales');
insert into departments(name)
values ('logistic');
insert into departments(name)
values ('building');

insert into employees(name, department_id)
values ('Pavel', null);
insert into employees(name, department_id)
values ('Sergey', 1);
insert into employees(name, department_id)
values ('Ivan', 2);
insert into employees(name, department_id)
values ('Olga', 3);
insert into employees(name, department_id)
values ('Maria', 3);
insert into employees(name, department_id)
values ('Fedor', 4);
insert into employees(name, department_id)
values ('Vasilii', 1);
insert into employees(name, department_id)
values ('Patrik', 4);
insert into employees(name, department_id)
values ('Bob', null);

/*          2       */
/* вывести имена работников и подразделения в которых они работают */
select e.name as "имя работника", d.name as "наименование подразделения"
from employees e
         left join departments d on e.department_id = d.id;

/* вывести подразделения и имена работников, которые в них работают */
select d.name as "наименование подразделения", e.name as "имя работника"
from employees e
         right join departments d on e.department_id = d.id
order by d.name;

/* вывести подразделения и имена работников */
select d.name as "наименование подразделения", e.name as "имя работника"
from employees e
         full join departments d on e.department_id = d.id;

/* cross join */
select d.name as "наименование подразделения", e.name as "имя работника"
from employees e
         cross join departments d;

/*          3       */
select d.name
from departments d
         left join employees e on d.id = e.department_id
where e.name is null;

/*          4       */
select d.name, e.name
from departments d
         left join employees e on d.id = e.department_id;

select d.name, e.name
from employees e
         right join departments d on d.id = e.department_id;

/*          5       */
create table teens
(
    id serial primary key,
    name varchar(255),
    gender varchar(255)
);

insert into teens(name, gender) VALUES ('Ivan', 'male');
insert into teens(name, gender) VALUES ('Pavel', 'male');
insert into teens(name, gender) VALUES ('Irina', 'female');
insert into teens(name, gender) VALUES ('Marina', 'female');
insert into teens(name, gender) VALUES ('Olga', 'female');

select t1.name, t2.name from teens t1 cross join teens t2
where t1.name < t2.name and t1.gender != t2.gender;
