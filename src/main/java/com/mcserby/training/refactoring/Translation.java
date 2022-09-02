package com.mcserby.training.refactoring;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Translation {

    private final List<String> values;
    private final Locale locale;

}
