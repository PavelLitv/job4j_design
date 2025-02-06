select p.*
from product p
         join type t on p.type_id = t.id
where t.name = 'СЫР';

select p.*
from product p
         join type t on p.type_id = t.id
where t.name like '%мороженое%';

select *
from product
where expired_date <= current_date;

select *
from product
where price = (select max(price) from product);

select *
from product
order by price desc
    FETCH FIRST 1 rows
with ties;

select p.name as "имя_типа", count(*) as "количество"
from product p
         join type t on p.type_id = t.id
group by p.name;

select p.*
from product p
         join type t on p.type_id = t.id
where t.name = 'СЫР'
   or t.name = 'МОЛОКО';

select t.name
from product p
         join type t on p.type_id = t.id
group by p.name
having count(*) < 10;

select p.*, t.name
from product p
         join type t on p.type_id = t.id;
