create table products
(
    id       serial primary key,
    name     varchar(50),
    producer varchar(50),
    count    integer default 0,
    price    integer
);

insert into products(name, count, price)
values ('product_23', 5, 10);

insert into products(name, producer, count, price)
values ('product_24', 'producer_24', 5, 0);

insert into products(name, producer, count)
values ('product_25', 'producer_25', 5);

create or replace procedure del_product_without_produce()
    language 'plpgsql'
as
$$
begin
    delete from products where producer is null;
end;
$$;

call del_product_without_produce();

create or replace function
    f_del_product_with_zero_price()
    returns integer
    language 'plpgsql'
as
$$
declare
    result integer;
begin
    select into result count(*)
    from products
    where price = 0 or price is null;
    delete
    from products
    where price = 0 or price is null;
    return result;
end;
$$;

select f_del_product_with_zero_price();
