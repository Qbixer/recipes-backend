package com.rysiki.recipes.recipe.exception;

public class RecipeNotFoundException extends RuntimeException{
    public RecipeNotFoundException(Integer id, String name) {
        super("Recipe with id=" + id + " and name=\"" + name + "\" was not found");
    }
    public RecipeNotFoundException(Integer id) {
        super("Recipe with id=" + id + " was not found");
    }
    public RecipeNotFoundException(String name) {
        super("Recipe with name=\"" + name + "\" was not found");
    }
}
