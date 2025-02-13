begin;
insert into employees(name, salary)
VALUES ('Pablo', 100000);
savepoint pablo_added;
update employees set salary = 999999
where name = 'Pablo';
savepoint salary_changed;
insert into employees(name, salary)
VALUES ('Jon Dow', 1);

select * from employees;

rollback to pablo_added;
rollback to salary_changed;
rollback;
commit;