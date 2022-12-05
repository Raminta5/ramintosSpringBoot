package com.example.demo.repository;

import com.example.demo.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    // SELECt * FROM customers WHERE customerName like 'a%'
    Optional<Customer> findByCustomerNumber(int id);
    Optional<Customer> findByCustomerName(String name);
    Iterable<Customer> findByCustomerNameLike(String name); // '%s'; '%new%'
}
