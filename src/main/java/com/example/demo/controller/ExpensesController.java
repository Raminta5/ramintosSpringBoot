package com.example.demo.controller;

import com.example.demo.model.Purchase;
import com.example.demo.service.ExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/expenses")
public class ExpensesController {

    @Autowired
    private ExpensesService expensesService;

    // http://127.0.0.1:8080/expenses/test
    @GetMapping(path = "/test")
    public @ResponseBody String getTestString() {
        return "Hello";
    }

    // http://127.0.0.1:8080/expenses/all
    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Purchase> getAllExpenses() {
        return expensesService.getAllExpenses();
    }

    // http://127.0.0.1:8080/purchase/18
    @GetMapping(path = "/{id}")
    public @ResponseBody
    Optional<Purchase> getPurchaseById(@PathVariable int id) {
        return expensesService.getPurchaseById(id);
    }



}
