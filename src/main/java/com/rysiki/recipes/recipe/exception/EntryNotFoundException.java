package com.rysiki.recipes.recipe.exception;

import com.rysiki.recipes.dictionary.enums.DictionaryTypeEnum;

public class EntryNotFoundException extends RuntimeException{
    public EntryNotFoundException(DictionaryTypeEnum dictionaryTypeEnum, String value) {
        super(dictionaryTypeEnum.toString() + ": entry \"" + value + "\" not found");
    }
}
