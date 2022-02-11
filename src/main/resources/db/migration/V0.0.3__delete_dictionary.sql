alter table recipe_meat drop constraint recipe_meat_meat_id_fk;

alter table recipe_meat
    add constraint recipe_meat_meat_id_fk
        foreign key (meat_id) references meat
            on delete cascade;

alter table recipe_ingredient drop constraint recipe_ingredient_ingredient_id_fk;

alter table recipe_ingredient
    add constraint recipe_ingredient_ingredient_id_fk
        foreign key (ingredient_id) references ingredient
            on delete cascade;

alter table recipe_filler drop constraint recipe_filler_filler_id_fk;

alter table recipe_filler
    add constraint recipe_filler_filler_id_fk
        foreign key (filler_id) references filler
            on delete cascade;