package com.rysiki.recipes.dictionary.controller;

import com.rysiki.recipes.dictionary.entity.Category;
import com.rysiki.recipes.dictionary.entity.Meat;
import com.rysiki.recipes.dictionary.repository.CategoryRepository;
import com.rysiki.recipes.dictionary.repository.MeatRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/category")
@RestController
public class CategoryController extends DictionaryController<Category, CategoryRepository> {

    CategoryController(CategoryRepository categoryRepository) {
        super(categoryRepository, Category.class);
    }
}
