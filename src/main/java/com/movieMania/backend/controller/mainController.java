package com.movieMania.backend.controller;

import com.movieMania.backend.BackendApplication;
import com.movieMania.backend.service.mainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Stack;

@RestController
@RequestMapping("/gateway")
@CrossOrigin
public class mainController {


    @Autowired
    private mainService mainService;


    @Autowired
    private BackendApplication backendApplication;


    @GetMapping("/getFromClient")
    private String getValue2(){
        return backendApplication.getVal2();
    }

    @GetMapping("/joinMeeting")
    private String setType(){
        return backendApplication.setType();
    }



}
