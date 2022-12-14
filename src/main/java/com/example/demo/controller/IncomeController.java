package com.example.demo.controller;

import com.example.demo.model.Income;
import com.example.demo.model.Purchase;
import com.example.demo.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequestMapping(path = "/incomes")
public class IncomeController {

    @Autowired
    private IncomeService incomeService;

    // http://127.0.0.1:8080/incomes/test
    @GetMapping(path = "/test")
    public @ResponseBody String getTestString() {
        return "Hello";
    }

    // http://127.0.0.1:8080/incomes/all
    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Income> getAllIncomes() {
        return incomeService.getAllIncomes();
    }

    // http://127.0.0.1:8080/incomes/18
    @GetMapping(path = "/{id}")
    public @ResponseBody
    Optional<Income> getIncomeById(@PathVariable int id) {
        return incomeService.getIncomeById(id);
    }



}
