package com.rysiki.recipes.recipe.entity;

import com.rysiki.recipes.dictionary.entity.Category;
import com.rysiki.recipes.dictionary.entity.Filler;
import com.rysiki.recipes.dictionary.entity.Ingredient;
import com.rysiki.recipes.dictionary.entity.Meat;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "recipe")
public class Recipe {
    @Id
    @GeneratedValue(generator = "recipe_id_seq")
    Integer id;

    @Column
    String name;

    @Column
    String source;

    @Column
    String yield;

    @EqualsAndHashCode.Exclude
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    @JoinTable(
            name="recipe_meat",
            joinColumns={@JoinColumn(name="recipe_id")},
            inverseJoinColumns={@JoinColumn(name="meat_id")})
    Set<Meat> meats;

    @EqualsAndHashCode.Exclude
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    @JoinTable(
            name="recipe_ingredient",
            joinColumns={@JoinColumn(name="recipe_id")},
            inverseJoinColumns={@JoinColumn(name="ingredient_id")})
    Set<Ingredient> ingredients;

    @EqualsAndHashCode.Exclude
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    @JoinTable(
            name="recipe_filler",
            joinColumns={@JoinColumn(name="recipe_id")},
            inverseJoinColumns={@JoinColumn(name="filler_id")})
    Set<Filler> fillers;

    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    Category category;
}
