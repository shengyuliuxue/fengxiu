package com.example.demo.api.v1;

import com.example.demo.exception.http.ServerErrorException;
import com.example.demo.util.JWTUtil;
import com.example.demo.util.MapAndJson;
import com.example.demo.vo.UserVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TokenController {
    @Autowired ObjectMapper  mapper;
    @PostMapping(path="v1/token", consumes = "application/json", produces = "application/json")
    public Map<String,String> getToken(@RequestBody UserVO account){
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

        Map<String, String> resultmap  = new HashMap<>();
        wexinLogResult result = new wexinLogResult();

        String resultStr = restTemplate.getForObject(url,String.class,map);
        //System.out.println(resultStr);
        try {
            wexinLogResult wr = mapper.readValue(resultStr, wexinLogResult.class);
            String openid = wr.getOpenid();
            String token = JWTUtil.CreateToken(openid);
            //{openid=ojOM646Uf1MtC6GtrDPDCKb3CtsE}
            //System.out.println(token);
            resultmap.put("token", token);
            return resultmap;
        }catch(JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }

    }

    @PostMapping(path="v1/token/verify", consumes = "application/json", produces = "application/json")
    public String verifyToken(@RequestBody String jsonStr){

        System.out.println(jsonStr);
        return jsonStr;
    }

}


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class wexinLogResult{
    public String session_key;
    public String openid;
}
