package com.pro.sky.Emloyees;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExceptionDepartament extends IllegalArgumentException{
    public ExceptionDepartament(String s) {
        super(s);
    }
}
