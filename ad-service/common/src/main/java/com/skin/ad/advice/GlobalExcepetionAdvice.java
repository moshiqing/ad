package com.skin.ad.advice;

import com.skin.ad.exception.Adexception;
import com.skin.ad.vo.CommonResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExcepetionAdvice {

    @ExceptionHandler(value = Adexception.class)
    public CommonResponse<String> handlerAdException(HttpServletRequest req, Adexception ad){

        CommonResponse<String> response =new CommonResponse<>(-1,"business error");
        response.setData(ad.getMessage());
        return response;
    }
}
