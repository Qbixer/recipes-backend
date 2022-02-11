package com.rysiki.recipes.recipe.service;

import com.rysiki.recipes.dictionary.entity.Category;
import com.rysiki.recipes.dictionary.entity.Filler;
import com.rysiki.recipes.dictionary.entity.Ingredient;
import com.rysiki.recipes.dictionary.entity.Meat;
import com.rysiki.recipes.dictionary.enums.DictionaryTypeEnum;
import com.rysiki.recipes.dictionary.repository.CategoryRepository;
import com.rysiki.recipes.dictionary.repository.FillerRepository;
import com.rysiki.recipes.dictionary.repository.IngredientRepository;
import com.rysiki.recipes.dictionary.repository.MeatRepository;
import com.rysiki.recipes.recipe.dto.RecipeDTO;
import com.rysiki.recipes.recipe.entity.Recipe;
import com.rysiki.recipes.recipe.exception.EntryNotFoundException;
import com.rysiki.recipes.recipe.exception.RecipeNotFoundException;
import com.rysiki.recipes.recipe.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class RecipeService {

    CategoryRepository categoryRepository;
    FillerRepository fillerRepository;
    IngredientRepository ingredientRepository;
    MeatRepository meatRepository;
    RecipeRepository recipeRepository;

    public RecipeService(
            CategoryRepository categoryRepository,
            FillerRepository fillerRepository,
            IngredientRepository ingredientRepository,
            MeatRepository meatRepository,
            RecipeRepository recipeRepository
    ) {
        this.categoryRepository = categoryRepository;
        this.fillerRepository = fillerRepository;
        this.ingredientRepository = ingredientRepository;
        this.meatRepository = meatRepository;
        this.recipeRepository = recipeRepository;
    }


    public Recipe createRecipeFromRecipeDTO(RecipeDTO recipeDTO) throws EntryNotFoundException {
        Recipe recipe = Recipe.builder()
                .name(recipeDTO.getName())
                .source(recipeDTO.getSource())
                .yield(recipeDTO.getYield())
                .build();


        if(recipeDTO.getMeats() != null) {
            Set<Meat> meats = new HashSet<>();
            for(String meatName : recipeDTO.getMeats()) {
                Optional<Meat> optionalMeat = meatRepository.findByName(meatName);
                if(optionalMeat.isEmpty()) {
                    throw new EntryNotFoundException(DictionaryTypeEnum.MEAT,meatName);
                }
                meats.add(optionalMeat.get());
            }
            recipe.setMeats(meats);
        }

        if(recipeDTO.getIngredients() != null) {
            Set<Ingredient> ingredients = new HashSet<>();
            for(String ingredientName : recipeDTO.getIngredients()) {
                Optional<Ingredient> optionalIngredient = ingredientRepository.findByName(ingredientName);
                if(optionalIngredient.isEmpty()) {
                    throw new EntryNotFoundException(DictionaryTypeEnum.INGREDIENT,ingredientName);
                }
                ingredients.add(optionalIngredient.get());
            }
            recipe.setIngredients(ingredients);
        }

        if(recipeDTO.getFillers() != null) {
            Set<Filler> fillers = new HashSet<>();
            for(String fillerName : recipeDTO.getFillers()) {
                Optional<Filler> optionalFiller = fillerRepository.findByName(fillerName);
                if(optionalFiller.isEmpty()) {
                    throw new EntryNotFoundException(DictionaryTypeEnum.FILLER,fillerName);
                }
                fillers.add(optionalFiller.get());
            }
            recipe.setFillers(fillers);
        }

        if(recipeDTO.getCategory() != null) {
            Optional<Category> optionalCategory = categoryRepository.findByName(recipeDTO.getCategory());
            if(optionalCategory.isEmpty()) {
                throw new EntryNotFoundException(DictionaryTypeEnum.CATEGORY,recipeDTO.getCategory());
            }
            recipe.setCategory(optionalCategory.get());
        }
        return recipe;
    }

    public Recipe getRecipeById(Integer id) throws RecipeNotFoundException {
        Optional<Recipe> optionalRecipe = recipeRepository.findById(id);
        if(optionalRecipe.isEmpty()) {
            throw new RecipeNotFoundException(id);
        }
        return optionalRecipe.get();
    }

}
