package com.rysiki.recipes.recipe.controller;

import com.rysiki.recipes.recipe.dto.RecipeDTO;
import com.rysiki.recipes.recipe.entity.Recipe;
import com.rysiki.recipes.recipe.repository.RecipeRepository;
import com.rysiki.recipes.recipe.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RequestMapping("/recipe")
@RestController
public class RecipeController {

    RecipeRepository recipeRepository;
    RecipeService recipeService;

    public RecipeController(
            RecipeRepository recipeRepository,
            RecipeService recipeService
    ) {
        this.recipeRepository = recipeRepository;
        this.recipeService = recipeService;
    }

    @GetMapping("")
    public ResponseEntity<Set<RecipeDTO>> getAllRecipes() {
        return ResponseEntity.ok(recipeRepository.findAll().stream().map(RecipeDTO::createRecipeDTOFromRecipe).collect(Collectors.toSet()));
    }

    @PostMapping("")
    public ResponseEntity<RecipeDTO> createRecipe(@RequestBody RecipeDTO recipeDTO) {
        return ResponseEntity.ok(RecipeDTO.createRecipeDTOFromRecipe(recipeRepository.save(recipeService.createRecipeFromRecipeDTO(recipeDTO))));
    }

    @PutMapping("{id}")
    public ResponseEntity<RecipeDTO> updateRecipe(@PathVariable Integer id, @RequestBody RecipeDTO recipeDTO) {
        Recipe recipe = recipeService.getRecipeById(id);
        Recipe recipeFromRecipeDTO = recipeService.createRecipeFromRecipeDTO(recipeDTO);
        recipe.setName(recipeFromRecipeDTO.getName());
        recipe.setSource(recipeFromRecipeDTO.getSource());
        recipe.setYield(recipeFromRecipeDTO.getYield());
        recipe.setMeats(recipeFromRecipeDTO.getMeats());
        recipe.setIngredients(recipeFromRecipeDTO.getIngredients());
        recipe.setFillers(recipeFromRecipeDTO.getFillers());
        recipe.setCategory(recipeFromRecipeDTO.getCategory());
        return ResponseEntity.ok(RecipeDTO.createRecipeDTOFromRecipe(recipeRepository.save(recipe)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteRecipe(@PathVariable Integer id) {
        Recipe recipe = recipeService.getRecipeById(id);
        recipeRepository.delete(recipe);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<RecipeDTO> getRecipe(@PathVariable Integer id) {
        Recipe recipe = recipeService.getRecipeById(id);
        return ResponseEntity.ok(RecipeDTO.createRecipeDTOFromRecipe(recipe));
    }
}
