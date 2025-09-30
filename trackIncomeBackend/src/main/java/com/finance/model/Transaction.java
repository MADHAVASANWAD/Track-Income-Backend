package com.finance.model;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "transaction")
    String transaction;

    @Column(name = "transaction_category")
    String category;

    @Column(name = "date_of_transaction")
    String date;

    @Column(name = "amount")
    long amount;

    @Column(name = "recurring")
    boolean recurring;

}
