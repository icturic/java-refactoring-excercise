package com.mcserby.training.refactoring;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public class Locale {
    private final String language;

    public String getLanguage() {
        return language;
    }
}
