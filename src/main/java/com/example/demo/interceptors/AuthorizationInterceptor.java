package com.example.demo.interceptors;

import com.example.demo.util.ScopeLevel;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class AuthorizationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        ScopeLevel scopeLevel = getScopeLevel(handler);
        if(scopeLevel != null){
           int level = scopeLevel.value();
           //如果不为公共访问方法，验证token

        }
        return true;
    }

    private ScopeLevel getScopeLevel(Object handler){
        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            ScopeLevel scopeLevel = handlerMethod.getMethodAnnotation(ScopeLevel.class);
            if(scopeLevel != null){
                return scopeLevel;
            }
        }
        return null;
    }
}
