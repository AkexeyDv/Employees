package com.pro.sky.Emloyees;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExceptionEmployee extends IllegalArgumentException {
    public ExceptionEmployee(String s) {
        super(s);
    }

}
