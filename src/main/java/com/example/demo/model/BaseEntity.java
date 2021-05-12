package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

public class BaseEntity {
    @JsonIgnore
    private Date createTime;
    private Date updateTime;
    private Date deleteTime;
}
