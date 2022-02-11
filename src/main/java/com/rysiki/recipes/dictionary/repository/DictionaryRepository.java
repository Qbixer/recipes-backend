package com.rysiki.recipes.dictionary.repository;

import com.rysiki.recipes.dictionary.entity.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface DictionaryRepository<T extends Dictionary> extends JpaRepository<T, Integer> {

    Optional<T> findByName(String name);
}
