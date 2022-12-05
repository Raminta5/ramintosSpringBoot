package com.example.demo.controller;

import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/customer/templates")
public class CustomerTemplatesController {


        @Autowired
        private CustomerService customerService;

    // http://127.0.0.1:8080/customer/templates/test
    @GetMapping(path = "/test")
    public String getTestString() {
        return "html_test";
    }


}
