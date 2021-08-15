package com.example.demo.util;

import com.example.demo.exception.http.ServerErrorException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class GenericConverter {

    //???why
    //1、 setter 方法啥时候调用
    //2、为什么不用static方法？
    private static ObjectMapper objectMapper;

    @Autowired
    public void setObjectMapper(ObjectMapper mapper){
        GenericConverter.objectMapper = mapper;
    }

    public static <T> String objectToJson(T t){
        try {
           return objectMapper.writeValueAsString(t);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    } 

    public static <T> T jsonToObject(String jsonStr, Class<T> cls){
        if(jsonStr == null){
            return null;
        }
        try {
            T t = objectMapper.readValue(jsonStr, cls);
            return t;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }

    /**
     * 作者的方法
    public static <T> T jsonToObject(String s,  TypeReference<T> tr) {
        if (s == null) {
            return null;
        }
        try {
            T o = GenericAndJson.mapper.readValue(s, tr);
            return o;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }
     */



}
