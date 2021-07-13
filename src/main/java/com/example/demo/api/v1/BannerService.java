package com.example.demo.api.v1;

import com.example.demo.model.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BannerService {
    @Autowired
    private BannerRepository bannerRepository;
    public Optional<Banner> findById(Long id){
        return bannerRepository.findById(id);
    }
}
