package com.example.demo.api.v1;

import com.example.demo.model.Category;
import com.example.demo.model.Spu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpuRepository extends JpaRepository<Spu, Long> {
    Page<Spu> getSpuByCategoryId(long id, Pageable pageable);

    Optional<Spu> getSpuById(Long id);

    Page<Spu> getSpuByRootCategoryId(long id, Pageable pageable);
//    List<Spu>  getSpuByCategoryId(Long id, Pageable pageable);
//    List<Spu> getSpuByRootCategoryId(Long id);
}
