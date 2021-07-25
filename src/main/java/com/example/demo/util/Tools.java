package com.example.demo.util;

import com.example.demo.bo.PageCounter;

public class Tools {
    public static PageCounter pageConverter(Integer start, Integer count){
        int page = start/count;
        PageCounter pageCounter = PageCounter.builder().page(page).count(count).build();
        return pageCounter;
    }
}
