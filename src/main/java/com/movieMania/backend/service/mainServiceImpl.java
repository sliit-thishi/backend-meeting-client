package com.movieMania.backend.service;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.Stack;

@Service
public class mainServiceImpl implements mainService{


    private static Stack<String> a = new Stack<>();
    private static Stack<String> b = new Stack<>();


    @Override
    public String setVal(String val) {
        a.push(val);
        return "added";
    }

    @Override
    public String getVal() {
        while (!a.empty()){
            b.push(a.pop());
        }
        if (b.empty()){
            return "empty";
        }
        return b.pop();
    }
}
