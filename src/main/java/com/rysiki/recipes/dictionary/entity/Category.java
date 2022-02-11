package com.rysiki.recipes.dictionary.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name = "category")
public class Category extends Dictionary {
    @Id
    @GeneratedValue(generator = "category_id_seq")
    Integer id;
}
