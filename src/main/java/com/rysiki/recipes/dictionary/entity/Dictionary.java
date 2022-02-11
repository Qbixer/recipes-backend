package com.rysiki.recipes.dictionary.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public class Dictionary {

    @Column(unique = true)
    String name;
}
