package com.example.demo.bootStrap;

import com.example.demo.repository.ExpensesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private ExpensesRepository expensesRepository;

    public BootStrapData(ExpensesRepository expensesRepository) {
        this.expensesRepository = expensesRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        expensesRepository.findAll().forEach(System.out::println);
        System.out.println("-------------------------------");
        System.out.println(expensesRepository.findById(501));
    }
}
