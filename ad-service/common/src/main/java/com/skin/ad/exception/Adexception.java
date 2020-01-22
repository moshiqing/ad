package com.skin.ad.exception;

import org.springframework.stereotype.Component;

@Component
public class Adexception extends Exception {

    public Adexception(String message){
        super(message);
    }
}
