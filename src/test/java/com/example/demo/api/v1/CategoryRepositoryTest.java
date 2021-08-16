package com.example.demo.api.v1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class CategoryRepositoryTest {
    @Autowired
    CategoryRepository categoryRepository;

    @Test
    void findAllByIsRootOrderByIndex() {
        //categoryRepository.findAllByIsRootOrderByIndex(1);
        categoryRepository.findAll();
    }
}