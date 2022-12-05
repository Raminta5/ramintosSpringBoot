package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class CustomerService {
@Autowired
    private CustomerRepository customerRepository;

    public Iterable<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomer(int customerId){
        return customerRepository.findById(customerId);
    }


    public Optional<Customer> getCustomerById (int id){
        return customerRepository.findByCustomerNumber(id);
    }

    public Optional<Customer> getCustomerByName (String name){
        return customerRepository.findByCustomerName(name);
    }

    public Iterable<Customer> getCustomerLikeName (String likeName){
        return customerRepository.findByCustomerNameLike(likeName);
    }

}

