package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/customer")
public class CustomerController {

    // http://127.0.0.1:8080/customer/test
    @GetMapping(path = "/test")
    public @ResponseBody String getTestString(){
        return "Hello";
    }
}
