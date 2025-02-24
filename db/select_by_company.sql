CREATE TABLE company
(
    id   integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
    id         integer NOT NULL,
    name       character varying,
    company_id integer references company (id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

select p.name, c.name
from person p
         join company c on c.id = p.company_id
where c.id != 5;

select c.name, count(p.id)
from company c
         join person p on c.id = p.company_id
group by c.id
having count(p.id) = (select max(count) from (select count(*) as count from person group by company_id) as subquery);
