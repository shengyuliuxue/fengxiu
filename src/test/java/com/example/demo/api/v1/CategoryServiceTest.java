package com.example.demo.api.v1;

import com.example.demo.model.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CategoryServiceTest {
    @Autowired CategoryService service;
    @Test
    void findAll() {

            Map<String, List<Category>> map = service.findAll();
            System.out.println(map);


    }
}