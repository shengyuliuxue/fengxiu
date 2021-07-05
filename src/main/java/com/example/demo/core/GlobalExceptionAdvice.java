package com.example.demo.core;


import com.example.demo.exception.http.HttpException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(code= HttpStatus.INTERNAL_SERVER_ERROR)
    public UnifyResponse handleException(HttpServletRequest req){
        System.out.println("hello, this is Exception");
        String reqUrl = req.getRequestURI();
        String method = req.getMethod();
        return new UnifyResponse(9999,"服务器异常", method + " " + reqUrl);
    }

    @ExceptionHandler(value = HttpException.class)
    public ResponseEntity<UnifyResponse> handleHttpException(HttpServletRequest req, HttpException e){
        String reqUrl = req.getRequestURI();
        String method = req.getMethod();
        UnifyResponse unifyResponse = new UnifyResponse(e.getCode(), "XXX", method + " " + reqUrl);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpStatus httpStatus = HttpStatus.resolve(e.getHttpStatusCode());
        ResponseEntity<UnifyResponse> responseEntity = new ResponseEntity<UnifyResponse>(unifyResponse,
                httpHeaders,httpStatus);
        System.out.println("this is httpException!");
        return responseEntity;
    }
}
