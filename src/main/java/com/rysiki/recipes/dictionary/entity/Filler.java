package com.rysiki.recipes.dictionary.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name = "filler")
public class Filler extends Dictionary {
    @Id
    @GeneratedValue(generator = "filler_id_seq")
    Integer id;
}
