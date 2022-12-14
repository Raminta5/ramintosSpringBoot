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
@Table(name = "income")
@Setter @Getter @NoArgsConstructor
public class Income {

    @Id
    @Column(name = "id")
    private Integer id; // id
    @Column(name = "incomename")
    private String incomeName;
    @Column(name = "incomedate")
    private String incomeDate;
    @Column(name = "incomeamount")
    private BigDecimal incomeAmount;




    @Override
    public String toString() {
        return "Income{" +
                "id=" + id +
                ", expensesName='" + incomeName + '\'' +
                ", expensesDate='" + incomeDate + '\'' +
                ", amount='" + incomeAmount + '\'' +

                '}';
    }


}
