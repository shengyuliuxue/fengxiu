package com.example.demo.bo;

import org.dozer.DozerBeanMapper;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;


public class Paging<T, K> {
    private int totalPage;
    private long totalElement;
    private List<T> tList;

    public Paging(Page<T> page, Class<K> kClass){
        this.totalPage = page.getTotalPages();
        this.totalElement = page.getTotalElements();
        this.tList = page.getContent();
        CopyElement(page, kClass);
    }

    public List<K> CopyElement(Page<T> page, Class<K> kClass){
        DozerBeanMapper mapper = new DozerBeanMapper();
        List<K> klist = new ArrayList<>();
        for(T e : tList){
            K ko = mapper.map(e, kClass);
            klist.add(ko);
        }
        return klist;
    }

}
