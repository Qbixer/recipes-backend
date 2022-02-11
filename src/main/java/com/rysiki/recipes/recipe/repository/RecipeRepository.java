package com.rysiki.recipes.recipe.repository;

import com.rysiki.recipes.recipe.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

}
