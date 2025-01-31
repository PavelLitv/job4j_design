CREATE
DATABASE pgadmin_db;

create table users
(
    id    serial primary key,
    age   smallint,
    name  text,
    email text
);

insert into users(age, name, email)
values (44, 'Pavel', 'example@example.com');

update users
set age = 45;

delete
from users;