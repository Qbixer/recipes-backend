package com.rysiki.recipes.dictionary.controller;

import com.rysiki.recipes.dictionary.entity.Meat;
import com.rysiki.recipes.dictionary.repository.MeatRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/meat")
@RestController
public class MeatController extends DictionaryController<Meat, MeatRepository> {

    MeatController(MeatRepository meatRepository) {
        super(meatRepository, Meat.class);
    }
}
