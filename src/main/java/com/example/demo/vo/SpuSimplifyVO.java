package com.example.demo.vo;

import lombok.*;

import javax.persistence.Id;

@Getter
@Setter
public class SpuSimplifyVO {
    //@Id
    private Long id;
    private String title;
    private String subtitle;
    private String img;
    private String forThemeImg;
    private String price;
    private String discountPrice;
    private String description;
    private String tags;
    private String sketchSpecId;
    public SpuSimplifyVO(){};

}
