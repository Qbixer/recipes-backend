package com.rysiki.recipes.dictionary.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name = "ingredient")
public class Ingredient extends Dictionary {
    @Id
    @GeneratedValue(generator = "ingredient_id_seq")
    Integer id;
}
