package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Spec {
    private Long keyId;
    private Long valueId;
    private String key;
    private String value;

    public Spec(){
        keyId = Long.valueOf(777);
        valueId = Long.valueOf(777);
        key = "777";
        value = "777";
    }
    @Override
    public String toString(){
        return  "Spec{" +
                "key='" + key + '\'' +
                ", value = " + value +
                "}";
    }
}
