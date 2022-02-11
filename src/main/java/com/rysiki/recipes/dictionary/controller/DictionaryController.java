package com.rysiki.recipes.dictionary.controller;

import com.rysiki.recipes.dictionary.dto.DictionaryInput;
import com.rysiki.recipes.dictionary.entity.Dictionary;
import com.rysiki.recipes.dictionary.repository.DictionaryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class DictionaryController<T extends Dictionary, S extends DictionaryRepository<T>> {

    T createEntry() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        return subClass.getDeclaredConstructor().newInstance();
    }

    S dictionaryRepository;
    Class<T> subClass;

    public DictionaryController(S dictionaryRepository, Class<T> subClass) {
        this.dictionaryRepository = dictionaryRepository;
        this.subClass = subClass;
    }

    @GetMapping("")
    public ResponseEntity<List<String>> getAll() {
        return ResponseEntity.ok(dictionaryRepository.findAll().stream().map(Dictionary::getName).collect(Collectors.toList()));
    }

    @PostMapping("")
    public ResponseEntity<String> saveNew(@RequestBody DictionaryInput input) {
        String name = input.getName();
        if(name.isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        Optional<T> byName = dictionaryRepository.findByName(normalizeName(name));
        if(byName.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        try {
            T entry = createEntry();
            entry.setName(normalizeName(name));
            return ResponseEntity.ok(dictionaryRepository.save(entry).getName());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("{oldName}")
    public ResponseEntity<String> rename(@PathVariable String oldName, @RequestBody DictionaryInput input) {
        String name = input.getName();
        if(name.isBlank() || oldName.isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        Optional<T> byName = dictionaryRepository.findByName(oldName);
        if(byName.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        T entry = byName.get();
        entry.setName(normalizeName(name));
        return ResponseEntity.ok(dictionaryRepository.save(entry).getName());
    }

    @DeleteMapping("{name}")
    public ResponseEntity delete(@PathVariable String name) {
        Optional<T> byName = dictionaryRepository.findByName(name);
        if(byName.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        T entry = byName.get();
        dictionaryRepository.delete(entry);
        return ResponseEntity.ok().build();
    }



    private String normalizeName(String name) {
        return name.toLowerCase();
    }
}
