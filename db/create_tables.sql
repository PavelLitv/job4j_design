/*many to one*/
create table orders
(
    id          serial primary key,
    summa       int,
    customer_id int references customer (id)
);

create table customers
(
    id   serial primary key,
    name varchar(255)
);

/*one to one*/
create table account
(
    id        serial primary key,
    is_active boolean not null,
    nick      varchar(255)
);

create table user
(
    id         serial primary key,
    name       varchar(255),
    email      varchar(255),
    account_id int references account (id) unique
);


/*many to many*/
create table news_subscription
(
    id        serial primary key,
    theme      varchar(255)
);

create table user
(
    id         serial primary key,
    name       varchar(255)под
);

create table user_subscription
(
    id        serial primary key,
    user_id int references user(id),
    subscription_id int references news_subscription(id)
);
