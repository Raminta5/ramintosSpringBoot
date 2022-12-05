package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // http://127.0.0.1:8080/customer/test
    @GetMapping(path = "/test")
    public @ResponseBody String getTestString() {
        return "Hello";
    }

    // http://127.0.0.1:8080/customer/all
    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // http://127.0.0.1:8080/customer/114
    @GetMapping(path = "/{id}")
    public @ResponseBody
    Optional<Customer> getCustomer(@PathVariable int id) {
        return customerService.getCustomer(id);
    }

    // http://127.0.0.1:8080/customer/number/114
    @GetMapping(path = "/number/{id}")
    public @ResponseBody
    Optional<Customer> getCustomerByID(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }

    // http://127.0.0.1:8080/customer/name/Diecast%20Collectables // %20 vietoj tarpo
    @GetMapping(path = "/name/{customerName}")
    public @ResponseBody
    Optional<Customer> getCustomerByName(@PathVariable String customerName) {
        return customerService.getCustomerByName(customerName);
    }

    // http://127.0.0.1:8080/customer/nameLike/a
    @GetMapping(path = "/nameLike/{customerName}")
    public @ResponseBody
    Iterable<Customer> getCustomerByNameLike(@PathVariable String customerName) {
//        return customerService.getCustomerLikeName("%".concat(customerName).concat("%")); //ieskos vardu, kur bet kurioje vietoje yra a raide
        return customerService.getCustomerLikeName(String.format("%%%s%%", customerName));
    }


    // http://127.0.0.1:8080/customer/name/like?customerName=a%25
    @GetMapping(path = "/name/like")
    public @ResponseBody
    Iterable<Customer> getCustomerByNameLikeByParam(@RequestParam String customerName) {
//        return customerService.getCustomerLikeName("%".concat(customerName).concat("%")); //ieskos vardu, kur bet kurioje vietoje yra a raide
//        return customerService.getCustomerLikeName(String.format("%%%s%%", customerName));
        return customerService.getCustomerLikeName(customerName);

    }


}
