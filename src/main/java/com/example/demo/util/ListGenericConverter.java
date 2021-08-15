package com.example.demo.util;

import com.example.demo.exception.http.ServerErrorException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ListGenericConverter<T> {
    private static ObjectMapper mapper;

    @Autowired
    public void setMapper(ObjectMapper mapper){
        ListGenericConverter.mapper = mapper;
    }

    public static <T> String objectListToJson(T t){
        try {
            return mapper.writeValueAsString(t);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }

    public static <T> List<T> jsonToObjectList(String jsonStr, Class<T> cls){
       // ObjectMapper mapper = new ObjectMapper();
        ArrayList list = new ArrayList();
        try {
           list =  mapper.readValue(jsonStr,
                          mapper.getTypeFactory().constructCollectionType(List.class, cls));
           return list;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }

}
