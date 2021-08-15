package com.example.demo.bo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageCounter {
    private Integer page;
    private Integer count;
}
