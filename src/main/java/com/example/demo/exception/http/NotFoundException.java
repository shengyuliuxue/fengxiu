package com.example.demo.exception.http;

import com.example.demo.exception.http.HttpException;

public class NotFoundException extends HttpException {
    public NotFoundException(int code){
        this.httpStatusCode = 404;
        this.code = code;
    }
}