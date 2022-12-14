package com.example.demo.controller;

import com.example.demo.model.Income;
import com.example.demo.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/incomes/templates")
public class IncomeTemplatesController {


    @Autowired
    private IncomeService incomeService;


    // http://127.0.0.1:8080/incomes/templates/1
    @GetMapping(path = "/{id}")
    public String getPurchase(@PathVariable int id, Model model) {
        Optional<Income> income = incomeService.getIncomeById(id);

        if (income.isEmpty()) {
            return "html_test";
        }

        model.addAttribute("key_income", income.get());
        return "income_th";
    }

    //  http://127.0.0.1:8080/incomes/templates/all
    @GetMapping(path = "/all")
    public String getAllIncomes(Model model) {
        List<Income> incomes = (List<Income>) incomeService.getAllIncomes();
        model.addAttribute("listas", incomes);
        return "incomes_html";
    }

}
