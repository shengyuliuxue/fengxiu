package com.example.demo.util;

import com.example.demo.exception.http.ServerErrorException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.ArrayList;
import java.util.List;

@Converter(autoApply = true)
public class ListAndJson<T> implements AttributeConverter<List<T>, String> {
    @Autowired
    ObjectMapper mapper;
    @Override
    public String convertToDatabaseColumn(List<T> list) {
        try {
            return mapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }

    @Override
    public List<T> convertToEntityAttribute(String s) {
        try {
            List<T> tList = mapper.readValue(s, ArrayList.class);
            return tList;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }

    }
}
