package com.example.demo.api.v1;


import com.example.demo.model.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class BannerController {
    @Autowired
    private BannerService bannerService;
    @GetMapping("/banner")
    public Optional<Banner> banner(@RequestParam(value="id", defaultValue = "1") int id){
            //return  new Banner(1, "b-1", "首页顶部主banner", "");
        return bannerService.findById(id);
    }
}
