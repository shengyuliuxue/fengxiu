package com.example.demo.api.v1;

import com.example.demo.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Map;

@RestController
public class CategoryController {
    @Autowired CategoryService categoryService;
    @Autowired CategoryRepository repository;
    @GetMapping("category/all")
    //@ResponseBody
    public String  getAllCategory(){
        List<Category> list = repository.findAll();
        if(list == null){
            //System.out.println(map);
            return "no data";
        }
        return "categoryService.findAll";
    }
//    public String getAllCategory(){
//        return "categoryService.findAll()";
//    }
}
