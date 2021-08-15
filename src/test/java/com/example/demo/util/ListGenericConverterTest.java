package com.example.demo.util;

import com.example.demo.bo.PageCounter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListGenericConverterTest {

    @Test
    void jsonToObjectList() {
        String jsonstr = "[{\"page\": 100,\"count\":7},{\"page\":666,\"count\":123}]";
        List<PageCounter> list = ListGenericConverter.jsonToObjectList(jsonstr, PageCounter.class);
        System.out.println(list);
    }
}