package com.example.controller.utls;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//作为spring mvc的异常处理器
@RestControllerAdvice
public class ProjectExceptionAdvice {
//    拦截所有的异常信息
    @ExceptionHandler
    public R doException(Exception ex){
        ex.printStackTrace();
        return new R("服务器故障");
    }

}
