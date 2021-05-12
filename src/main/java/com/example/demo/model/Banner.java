package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Banner extends BaseEntity{
    @Id
    private int id;
    private String name;
    private String description;
    private String items;
}