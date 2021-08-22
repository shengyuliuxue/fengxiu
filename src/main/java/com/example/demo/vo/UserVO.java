package com.example.demo.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVO {
    private String account;
    private String type;
    @Override
    public String toString(){
        return "account: " + account + "\n" + "type" + type;
    }
}
