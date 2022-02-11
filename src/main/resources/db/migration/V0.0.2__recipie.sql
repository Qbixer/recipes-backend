create table recipe
(
    id serial not null
        constraint recipe_pk
            primary key,
    name varchar(255) not null,
    source text,
    yield varchar(1000),
    category_id int
        constraint recipe_category_id_fk
            references category
);

create table recipe_meat
(
    recipe_id int not null
        constraint recipe_meat_recipe_id_fk
            references recipe,
    meat_id int not null
        constraint recipe_meat_meat_id_fk
            references meat,
    constraint recipe_meat_pk
        unique (recipe_id, meat_id)
);

create table recipe_ingredient
(
    recipe_id int not null
        constraint recipe_ingredient_recipe_id_fk
            references recipe,
    ingredient_id int not null
        constraint recipe_ingredient_ingredient_id_fk
            references ingredient,
    constraint recipe_ingredient_pk
        unique (recipe_id, ingredient_id)
);

create table recipe_filler
(
    recipe_id int not null
        constraint recipe_filler_recipe_id_fk
            references recipe,
    filler_id int not null
        constraint recipe_filler_filler_id_fk
            references filler,
    constraint recipe_filler_pk
        unique (recipe_id, filler_id)
);