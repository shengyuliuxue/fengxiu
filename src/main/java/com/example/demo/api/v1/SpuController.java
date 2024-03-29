package com.example.demo.api.v1;

import com.example.demo.bo.PageCounter;
import com.example.demo.bo.Paging;
import com.example.demo.exception.http.NotFoundException;
import com.example.demo.model.Spec;
import com.example.demo.model.Spu;
import com.example.demo.util.Tools;
import com.example.demo.vo.SpuSimplifyVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@Validated
public class SpuController {
    @Autowired SpuService spuService;
    @GetMapping("/spu/{id}/detail")
    public Optional<Spu> spu(@PathVariable("id") @NotBlank @Positive(message = "{id.positive}")  Long id){
        Optional<Spu> spu = spuService.getSpu(id);
        if(spu.isPresent()){
            return spu;
        }else {
            throw new NotFoundException(10001);
        }
    }

    @GetMapping("/spu/{id}/simplify")
    public SpuSimplifyVO getSpuSimplify(@PathVariable("id") @NotBlank Long id){
        DozerBeanMapper  mapper = new DozerBeanMapper();
        Optional<Spu> spu = spuService.getSpu(id);
        //SpuSimplifyVO svo = new SpuSimplifyVO();
        if(spu.isPresent()){
           SpuSimplifyVO svo = mapper.map(spu.get(), SpuSimplifyVO.class);
          //  BeanUtils.copyProperties(spu.get(), svo);
            System.out.println(svo.getTitle());
            return svo;
        }else {
            throw new NotFoundException(10001);
        }

    }



//    @GetMapping("/spulatest")
//    public List<SpuSimplifyVO> getLatestSpu(@RequestParam(defaultValue = "0") Integer start,
//                                  @RequestParam(defaultValue = "2") Integer count){
//        PageCounter pageCounter = Tools.pageConverter(start,count);
//        Page<Spu> pageSpu = spuService.getSpuLatest(pageCounter.getPage(), pageCounter.getCount());
//
//        int totalPage = pageSpu.getTotalPages();
//        long totalElements = pageSpu.getTotalElements();
//        List<Spu> listSpu = pageSpu.getContent();
//
//        DozerBeanMapper mapper = new DozerBeanMapper();
//        List<SpuSimplifyVO> listSimplySpu = new ArrayList<SpuSimplifyVO>();
//        for(Spu s : listSpu){
//            SpuSimplifyVO svo = mapper.map(s, SpuSimplifyVO.class);
//            listSimplySpu.add(svo);
//        }
//        return listSimplySpu;
//    }


    @GetMapping("/spulatest")
    public List<SpuSimplifyVO> getLatestSpu(@RequestParam(defaultValue = "0") Integer start,
                                            @RequestParam(defaultValue = "2") Integer count){
        PageCounter pageCounter = Tools.pageConverter(start,count);
        Page<Spu> pageSpu = spuService.getSpuLatest(pageCounter.getPage(), pageCounter.getCount());
        Paging<Spu, SpuSimplifyVO> paging = new Paging<>(pageSpu, SpuSimplifyVO.class);
        System.out.println("666666666666666666666666666666666");
        return paging.getKList();
    }

    @GetMapping("category/{id}")
    public Paging<Spu, SpuSimplifyVO> getCategory( @PathVariable("id") @Positive(message = "must positive!!!")  Long id,
                                            @RequestParam(defaultValue = "false") Boolean is_root,
                                            @RequestParam(defaultValue = "0") Integer start,
                                            @RequestParam(defaultValue = "2") Integer count){
        PageCounter pageCounter = Tools.pageConverter(start,count);
        Pageable pageable = PageRequest.of(pageCounter.getPage(),pageCounter.getCount());
        Page<Spu> pageSpu = spuService.getCategory(false,id, pageable);
        Paging<Spu, SpuSimplifyVO> paging = new Paging<>(pageSpu, SpuSimplifyVO.class);
        return paging;
    }


    @GetMapping("specSeri")
    public String getSpecJson() throws JsonProcessingException {
        Spec spec = new Spec(Long.valueOf(1),Long.valueOf(1),"car", "jeep");
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(spec);
        System.out.println(jsonString);
        return jsonString;
    }

    @GetMapping("specDseri")
    public void deSpecJson() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"keyId\":1,\"valueId\":1,\"key\":\"car\",\"value\":\"BYD\"}";
        Spec spec = mapper.readValue(jsonString, Spec.class);
        System.out.println(spec);

    }

    @GetMapping("mapAndJson")
    public void mapjson(){
        String jsonString = "{\"keyId\":1,\"valueId\":1,\"key\":\"car\",\"value\":\"BYD\"}";

    }


}







