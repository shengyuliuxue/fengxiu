package com.example.demo.api.v1;

import com.example.demo.model.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface BannerRepository extends JpaRepository<Banner, Integer> {
  Optional<Banner> findById(Integer id);
    //Banner findByName(String name);
}
