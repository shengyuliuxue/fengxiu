package com.example.demo.api.v1;

import com.example.demo.model.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface BannerRepository extends JpaRepository<Banner, Long> {
  Optional<Banner> findById(Long id);
    //Banner findByName(String name);
}
