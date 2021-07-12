package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Spu extends BaseEntity{
    @Id
    private int id;
    private String title;
    private String subtitle;
    private Boolean online;
    private String price;
    private String img;
    private String discountPrice;
    private String description;
    private String tags;
    private Boolean isTest;
}
