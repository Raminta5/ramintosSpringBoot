package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "dailyexpenses")
@Setter @Getter @NoArgsConstructor
public class Purchase {

    @Id
    @Column(name = "id")
    private Integer id; // id
    @Column(name = "expensesname")
    private String expensesName;
    @Column(name = "expensesdate")
    private String expensesDate;
    @Column(name = "amount")
    private BigDecimal amount;




    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", expensesName='" + expensesName + '\'' +
                ", expensesDate='" + expensesDate + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }


}
