package com.example.demo.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Banner extends BaseEntity{
    @Id
    private int id;
    private String name;
    private String description;
    private String items;
}