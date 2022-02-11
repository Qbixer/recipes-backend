package com.rysiki.recipes.dictionary.controller;

import com.rysiki.recipes.dictionary.entity.Filler;
import com.rysiki.recipes.dictionary.repository.FillerRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/filler")
@RestController
public class FillerController extends DictionaryController<Filler, FillerRepository> {

    FillerController(FillerRepository fillerRepository) {
        super(fillerRepository, Filler.class);
    }
}
