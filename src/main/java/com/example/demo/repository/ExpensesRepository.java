package com.example.demo.repository;

import com.example.demo.model.Purchase;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface ExpensesRepository extends CrudRepository<Purchase, Integer> {
    Optional<Purchase> findById(int id);
//    Optional<Purchase> findByPurchaseName(String expensesName);
}
