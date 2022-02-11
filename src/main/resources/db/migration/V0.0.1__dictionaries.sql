create table meat
(
    id serial not null
        constraint meat_pk
            primary key,
    name varchar(255)
);

create unique index meat_name_uindex
    on meat (name);

create table filler
(
    id serial not null
        constraint filler_pk
            primary key,
    name varchar(255)
);

create unique index filler_name_uindex
    on filler (name);

create table ingredient
(
    id serial not null
        constraint ingredient_pk
            primary key,
    name varchar(255)
);

create unique index ingredient_name_uindex
    on ingredient (name);

create table category
(
    id serial not null
        constraint category_pk
            primary key,
    name varchar(255)
);

create unique index category_name_uindex
    on category (name);