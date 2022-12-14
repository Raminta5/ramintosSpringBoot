package com.example.demo.repository;

import com.example.demo.model.Purchase;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface ExpensesRepository extends CrudRepository<Purchase, Integer> {
    Optional<Purchase> findById(int id);
//    Optional<Purchase> findByPurchaseName(String expensesName);

    @Query("SELECT SUM(amount) FROM Purchase")
    BigDecimal totalSum();

}
