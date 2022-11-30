package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequestMapping(path = "/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // http://127.0.0.1:8080/customer/test
    @GetMapping(path = "/test")
    public @ResponseBody String getTestString(){
        return "Hello";
    }

    // http://127.0.0.1:8080/customer/all
    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    // http://127.0.0.1:8080/customer/114
    @GetMapping(path = "/{id}")
    public @ResponseBody
    Optional<Customer> getCustomer(@PathVariable int id){
        return customerService.getCustomer(id);
    }


}
