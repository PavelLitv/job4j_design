create table products
(
    id       serial primary key,
    name     varchar(50),
    producer varchar(50),
    count    integer default 0,
    price    integer
);

create table history_of_price
(
    id    serial primary key,
    name  varchar(50),
    price integer,
    date  timestamp
);

/* ---------------1-------------- */
create
    or replace function tax()
    returns trigger as
$$
BEGIN
    update products
    set price = price + price * 0.2
    where id = (select id from inserted);
    return new;
END;
$$
    LANGUAGE 'plpgsql';

create trigger tax_trigger
    after insert
    on products
    referencing new table as
        inserted
    for each statement
execute procedure tax();

/* ---------------2-------------- */
create
    or replace function tax_row()
    returns trigger as
$$
BEGIN
    new.price := new.price + new.price * 0.2;
    return new;
END;
$$
    LANGUAGE 'plpgsql';

create trigger tax_trigger_row
    before insert
    on products
    for each row
execute procedure tax_row();

/* ---------------3-------------- */
create
    or replace function product_history()
    returns trigger as
$$
BEGIN
    insert into history_of_price(name, price, date) VALUES (new.name, new.price, current_timestamp);
    return new;
END;
$$
    LANGUAGE 'plpgsql';

create trigger history_price
    after insert
    on products
    for each row
execute procedure product_history();
