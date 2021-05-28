package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Getter
@Setter
public class BannerItem extends BaseEntity{
    @Id
    private int id;
    private String img;
    private String keyword;
    private short type;
    private String name;
    private int banner_id;
}
