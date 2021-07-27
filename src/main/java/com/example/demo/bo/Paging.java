package com.example.demo.bo;

import lombok.Getter;
import lombok.Setter;
import org.dozer.DozerBeanMapper;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Paging<T, K> {
    private int totalPage;
    private long totalElement;
    private List<K> kList;

    public Paging(Page<T> page, Class<K> kClass){
        this.totalPage = page.getTotalPages();
        this.totalElement = page.getTotalElements();
        this.kList = CopyElement(page, kClass);
    }

    public List<K> CopyElement(Page<T> page, Class<K> kClass){
        DozerBeanMapper mapper = new DozerBeanMapper();
        List<K> klist = new ArrayList<>();
        for(T e : page.getContent()){
            K ko = mapper.map(e, kClass);
            klist.add(ko);
        }
        return klist;
    }

}
