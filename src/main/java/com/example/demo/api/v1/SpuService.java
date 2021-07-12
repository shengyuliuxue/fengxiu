package com.example.demo.api.v1;

import com.example.demo.model.Spu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpuService {
    @Autowired SpuRepository spuRepository;
   public Optional<Spu> getSpu(Integer id){
       return spuRepository.getSpuById(id);
   }

   public List<Spu> getSpuLatest(){
       return spuRepository.findAll();
   }
}
