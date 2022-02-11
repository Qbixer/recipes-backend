package com.rysiki.recipes.dictionary.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name = "meat")
public class Meat extends Dictionary {
    @Id
    @GeneratedValue(generator = "meat_id_seq")
    Integer id;
}
