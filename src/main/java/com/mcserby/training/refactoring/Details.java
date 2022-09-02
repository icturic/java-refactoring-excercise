package com.mcserby.training.refactoring;

import lombok.Getter;

@Getter
public class Details {

    private String name = null;

    private String description = null;

    public Details name(String name) {
        this.name = name;
        return this;
    }

    public Details description(String description) {
        this.description = description;
        return this;
    }
}
