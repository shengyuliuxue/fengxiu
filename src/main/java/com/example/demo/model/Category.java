package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Category extends BaseEntity{
    @Id
    private Long id;
    private String name;
    private String description;
    private int level;
    private Boolean isRoot;
    private Long parentId;
    private String img;
    private int index;
    private Boolean online;
}
