package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

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

    //  http://localhost:8080/customer/templates/firstpage/112
    @GetMapping(path = "/firstpage/{id}")
    public String getCustomerDetails(@PathVariable int id, Model model) {
        Optional<Customer> customer = customerService.getCustomerById(id);
        model.addAttribute("company_name", customer.get().getCustomerName());
        model.addAttribute("contact_last_name", customer.get().getContactLastName());
        model.addAttribute("contact_first_name", customer.get().getContactFirstName());
        model.addAttribute("country", customer.get().getCountry());
        return "firstpage";
    }

    // http://127.0.0.1:8080/customer/templates/501
    @GetMapping(path = "/{id}")
    public String getCustomer(@PathVariable int id, Model model)
    {
        Optional<Customer> customer = customerService.getCustomerById(id);

        if(customer.isEmpty()){
            return "html_test";
        }

//        Customer customer = customerService.getCustomerById(id).get();
        model.addAttribute("key_customer", customer.get());
        return "customer_th";
    }




}
