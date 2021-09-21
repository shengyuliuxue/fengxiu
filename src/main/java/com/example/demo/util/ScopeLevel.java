package com.example.demo.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface ScopeLevel {
    int value() default 6;
}
