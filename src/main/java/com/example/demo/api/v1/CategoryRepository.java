package com.example.demo.api.v1;

import com.example.demo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category>  findAllByIsRootOrderByIndex(int is_root);
}
