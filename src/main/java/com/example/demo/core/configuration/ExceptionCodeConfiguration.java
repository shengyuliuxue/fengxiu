package com.example.demo.core.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties(prefix = "lin")
@PropertySource(value = "classpath:config/exception-code.properties")
@Getter
@Setter
@Component
public class ExceptionCodeConfiguration {
    private Map<Integer, String> codes = new HashMap<>();
    public String getMessage(int code){
        String message = codes.get(code);
        return message;
    }
}
