package com.rysiki.recipes.dictionary.controller;

import com.rysiki.recipes.dictionary.entity.Ingredient;
import com.rysiki.recipes.dictionary.repository.IngredientRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/ingredient")
@RestController
public class IngredientController extends DictionaryController<Ingredient, IngredientRepository> {

    IngredientController(IngredientRepository ingredientRepository) {
        super(ingredientRepository, Ingredient.class);
    }
}
