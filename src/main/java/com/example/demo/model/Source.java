package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Source {
    private String name;
    private int age;

    public Source() {}

    public Source(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // standard getters and setters
}