package com.example.demo.api.v1;

import com.example.demo.model.Category;
import com.example.demo.model.Spu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class SpuService {
    @Autowired SpuRepository spuRepository;

   public Optional<Spu> getSpu(Long id){
       return spuRepository.getSpuById(id);
   }
   public List<Spu> getSpuLatest(){
       return spuRepository.findAll();
   }
   public Page<Spu> getSpuLatest(Integer page, Integer size){
       Pageable firstPageWithTwoElements =  PageRequest.of(page,size);
       Page<Spu> spus = spuRepository.findAll(firstPageWithTwoElements);
       return spus;
   }

   public Page<Spu> getCategory(Boolean is_root, long  id, Pageable pageable){
       //
       if(is_root){
          return spuRepository.getSpuByRootCategoryId(id, pageable);
       }else {
           return  spuRepository.getSpuByCategoryId(id, pageable);
       }

   }
}
