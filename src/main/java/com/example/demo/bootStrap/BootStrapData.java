package com.example.demo.bootStrap;

import com.example.demo.repository.ExpensesRepository;
import com.example.demo.repository.IncomeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BootStrapData implements CommandLineRunner {

    private ExpensesRepository expensesRepository;
    private IncomeRepository incomeRepository;

    public BootStrapData(ExpensesRepository expensesRepository, IncomeRepository incomeRepository) {
        this.expensesRepository = expensesRepository;
        this.incomeRepository = incomeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        expensesRepository.findAll().forEach(System.out::println);

        incomeRepository.findAll().forEach(System.out::println);

        System.out.println("Iš viso išlaidų: " + (expensesRepository.totalSum()));
        System.out.println("Iš viso įplaukų: " + (incomeRepository.totalIncomeSum()));
        System.out.println("Pinigų likutis: " + ((incomeRepository.totalIncomeSum()).subtract(expensesRepository.totalSum())));
    }

}
