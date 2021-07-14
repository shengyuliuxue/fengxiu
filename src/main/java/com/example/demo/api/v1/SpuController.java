package com.example.demo.api.v1;

import com.example.demo.exception.http.NotFoundException;
import com.example.demo.model.Dest;
import com.example.demo.model.Source;
import com.example.demo.model.Spu;
import com.example.demo.vo.SpuSimplifyVO;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

@RestController
public class SpuController {
    @Autowired SpuService spuService;
    @GetMapping("/spu/{id}/detail")
    public Optional<Spu> spu(@PathVariable("id") @NotBlank  Long id){
        Optional<Spu> spu = spuService.getSpu(id);
        if(spu.isPresent()){
            return spuService.getSpu(id);
        }else {
            throw new NotFoundException(10001);
        }
    }

    @GetMapping("/spu/{id}/simplify")
    public SpuSimplifyVO getSpuSimplify(@PathVariable("id") @NotBlank Long id){
        DozerBeanMapper  mapper = new DozerBeanMapper();
        Optional<Spu> spu = spuService.getSpu(id);
        if(spu.isPresent()){
            SpuSimplifyVO svo = mapper.map(spu, SpuSimplifyVO.class);
            return svo;
        }else {
            throw new NotFoundException(10001);
        }
    }


    @GetMapping("/mapper")
    public Dest mapper(){
        DozerBeanMapper  mapper = new DozerBeanMapper();
        Source source = new Source("Baeldung", 10);
        Dest dest = mapper.map(source, Dest.class);
        System.out.println(dest.toString());
        return  dest;
    }

    @GetMapping("/spulatest")
    public List<Spu> getLatestSpu(){
        return spuService.getSpuLatest();
    }
}
