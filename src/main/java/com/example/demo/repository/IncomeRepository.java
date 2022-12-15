package com.example.demo.repository;

import com.example.demo.model.Income;
import com.example.demo.model.Purchase;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface IncomeRepository extends CrudRepository<Income, Integer> {
    Optional<Income> findById(int id);
//    Optional<Purchase> findByPurchaseName(String expensesName);

    @Query("SELECT SUM(incomeAmount) FROM Income")
    BigDecimal totalIncomeSum();



}
