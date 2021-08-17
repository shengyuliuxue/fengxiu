package com.example.demo.api.v1;

import com.example.demo.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    public  List<Category> findAll(){
//        List<Category>  roots = categoryRepository.findAllByIsRootOrderByIndex(1);
//        List<Category>  subs = categoryRepository.findAllByIsRootOrderByIndex(0);
//        List<Category>  roots = categoryRepository.findAll();
//        List<Category>  subs = categoryRepository.findAll();
//        HashMap<String, List<Category>> map = new HashMap<>();
//        map.put("roots", roots);
//        map.put("subs", subs);
//        return map;
        return categoryRepository.findAll();
    }
}
