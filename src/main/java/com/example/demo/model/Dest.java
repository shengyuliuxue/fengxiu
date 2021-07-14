package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dest {
    private String name;
    private int age;

    public Dest() {}

    public Dest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // standard getters and setters
}