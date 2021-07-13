package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Banner extends BaseEntity{
    @Id
    private Long id;
    private String name;
    private String description;
    private String items;

    @OneToMany(mappedBy = "banner_id",fetch = FetchType.EAGER)
    private List<BannerItem> bannerItems;
}