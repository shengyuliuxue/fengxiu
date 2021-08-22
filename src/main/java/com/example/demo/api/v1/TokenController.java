package com.example.demo.api.v1;

import com.example.demo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TokenController {

    @PostMapping(path="v1/token", consumes = "application/json", produces = "application/json")
    public void getToken(@RequestBody UserVO account){
        //appid:  wxe020efca01975f5b
        //Appsecret: 83eda50dea97ce05efcce515b29f989e
        //code: account
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.weixin.qq.com/sns/jscode2session?" +
                "appid={APPID}&secret={SECRET}&js_code={JSCODE}&grant_type=authorization_code";
        Map<String, String> map = new HashMap<>();
        map.put("APPID","wxe020efca01975f5b");
        map.put("SECRET","83eda50dea97ce05efcce515b29f989e");
        map.put("JSCODE",account.getAccount());

        String result = restTemplate.getForObject(url,String.class,map);
        System.out.println(result);
    }
}
