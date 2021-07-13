package com.example.demo.api.v1;

import com.example.demo.model.Spu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpuRepository extends JpaRepository<Spu, Long> {
    Optional<Spu> getSpuById(Long id);
}
