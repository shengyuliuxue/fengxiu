package com.example.demo.api.v1;

import com.example.demo.exception.http.NotFoundException;
import com.example.demo.model.Spu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

@RestController
public class SpuController {
    @Autowired SpuService spuService;
    @GetMapping("/spu/{id}")
    public Optional<Spu> spu(@PathVariable("id") @NotBlank  int id){
        Optional<Spu> spu = spuService.getSpu(id);
        if(spu.isPresent()){
            return spuService.getSpu(id);
        }else {
            throw new NotFoundException(10001);
        }
    }

    @GetMapping("/spulatest")
    public List<Spu> getLatestSpu(){
        return spuService.getSpuLatest();
    }
}
