package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Theme {
    @Id
    private Long id;
    private String name;
    private String title;
    private String img;
    private String description;

    @ManyToMany
    @JoinTable(
            name = "Theme_Spu",
            joinColumns =  @JoinColumn(name="Theme_id"),
            inverseJoinColumns = @JoinColumn(name = "Spu_id")
    )
    private List<Spu> spuList;
}
