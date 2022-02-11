package com.rysiki.recipes.recipe.dto;

import com.rysiki.recipes.dictionary.entity.Filler;
import com.rysiki.recipes.dictionary.entity.Ingredient;
import com.rysiki.recipes.dictionary.entity.Meat;
import com.rysiki.recipes.recipe.entity.Recipe;
import lombok.Builder;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
public class RecipeDTO {

    Integer id;
    String name;
    String source;
    String yield;
    Set<String> meats;
    Set<String> ingredients;
    Set<String> fillers;
    String category;

    public static RecipeDTO createRecipeDTOFromRecipe(Recipe recipe) {
        RecipeDTO recipeDTO = RecipeDTO.builder()
                .id(recipe.getId())
                .name(recipe.getName())
                .source(recipe.getSource())
                .yield(recipe.getYield())
                .build();
        if(recipe.getMeats() != null) {
            recipeDTO.setMeats(recipe.getMeats().stream().map(Meat::getName).collect(Collectors.toSet()));
        } else {
            recipeDTO.setMeats(new HashSet<>());
        }

        if(recipe.getIngredients() != null) {
            recipeDTO.setIngredients(recipe.getIngredients().stream().map(Ingredient::getName).collect(Collectors.toSet()));
        } else {
            recipeDTO.setIngredients(new HashSet<>());
        }

        if(recipe.getFillers() != null) {
            recipeDTO.setFillers(recipe.getFillers().stream().map(Filler::getName).collect(Collectors.toSet()));
        } else {
            recipeDTO.setFillers(new HashSet<>());
        }

        if(recipe.getCategory() != null) {
            recipeDTO.setCategory(recipe.getCategory().getName());
        } else {
            recipeDTO.setCategory(null);
        }
        return recipeDTO;
    }
}
