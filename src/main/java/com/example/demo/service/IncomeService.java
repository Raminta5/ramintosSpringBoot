package com.example.demo.service;

import com.example.demo.model.Income;
import com.example.demo.model.Purchase;
import com.example.demo.repository.ExpensesRepository;
import com.example.demo.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class IncomeService {
@Autowired
    private IncomeRepository incomeRepository;

    public Iterable<Income> getAllIncomes(){
        return incomeRepository.findAll();
    }


    public Optional<Income> getIncomeById (int id){
        return incomeRepository.findById(id);
    }





}

