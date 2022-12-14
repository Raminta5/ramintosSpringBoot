package com.example.demo.service;

import com.example.demo.model.Purchase;
import com.example.demo.repository.ExpensesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class ExpensesService {
@Autowired
    private ExpensesRepository expensesRepository;

    public Iterable<Purchase> getAllExpenses(){
        return expensesRepository.findAll();
    }

    public Optional<Purchase> getPurchaseById (int id){
        return expensesRepository.findById(id);
    }





}

