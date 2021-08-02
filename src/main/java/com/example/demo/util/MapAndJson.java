package com.example.demo.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class MapAndJson{
    @Autowired
    static ObjectMapper mapper;

    public static  <T> String ConvertToJson(Map<String, T> map) throws JsonProcessingException {
        String jsonString = mapper.writeValueAsString(map);
        return jsonString;
    }

    public static <T> T ConvertToMap(String jsonString, Class<T> cls) throws JsonProcessingException {
          T t = mapper.readValue(jsonString, cls);
          return t;
    }

}
