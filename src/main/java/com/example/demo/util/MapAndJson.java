package com.example.demo.util;

import com.example.demo.exception.http.ServerErrorException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Converter(autoApply = true)
public class MapAndJson<T> implements AttributeConverter<Map<String,T>, String> {
    @Autowired ObjectMapper  mapper;

    @Override
    public String convertToDatabaseColumn(Map<String,T> t) {
        try {
            return  mapper.writeValueAsString(t);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }

    @Override
    public Map<String,T> convertToEntityAttribute(String jsonStr) {
        try {
            return  mapper.readValue(jsonStr, HashMap.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }

}
