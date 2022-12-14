package com.example.demo.controller;

import com.example.demo.model.Income;
import com.example.demo.model.Purchase;
import com.example.demo.service.ExpensesService;
import com.example.demo.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/expenses/templates")
public class ExpensesTemplatesController {


    @Autowired
    private ExpensesService expensesService;


    @Autowired
    private IncomeService incomeService;


    // http://127.0.0.1:8080/expenses/templates/18
    @GetMapping(path = "/{id}")
    public String getPurchase(@PathVariable int id, Model model) {
        Optional<Purchase> purchase = expensesService.getPurchaseById(id);

        if (purchase.isEmpty()) {
            return "html_test";
        }

        model.addAttribute("key_purchase", purchase.get());
        return "purchase_th";
    }

    //  http://127.0.0.1:8080/expenses/templates/all
    @GetMapping(path = "/all")
    public String getAllExpenses(Model model) {
        List<Purchase> expenses = (List<Purchase>) expensesService.getAllExpenses();
        model.addAttribute("listas", expenses);

        List<Income> incomes = (List<Income>) incomeService.getAllIncomes();
        model.addAttribute("incomeListas", incomes);


        BigDecimal expensesSum = expensesService.getExpensesSum();
        BigDecimal incomeSum = incomeService.getIncomeSum();
        BigDecimal difference = incomeService.getDifference();
        model.addAttribute("expensesSum", expensesSum.toString());
        model.addAttribute("incomeSum", incomeSum.toString());
        model.addAttribute("difference", difference.toString());
        return "expenses_html";
    }

}
