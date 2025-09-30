package com.finance.service;

import com.finance.exception.ResourceNotFoundException;
import com.finance.model.Transaction;
import com.finance.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepo transactionRepo;

    public List<Transaction> getall() {
        return transactionRepo.findAll();
    }

    public Transaction insert(Transaction t) {
        System.out.println(t.getTransaction());
        System.out.println(t.getAmount());
        System.out.println(t.getCategory());
        System.out.println(t.getDate());
        return transactionRepo.save(t);
    }

    public Transaction update(Transaction t, int id) {
        Transaction transaction = transactionRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Transaction","id",id));
        transaction.setTransaction(t.getTransaction());
        transaction.setDate(t.getDate());
        transaction.setAmount(t.getAmount());
        transaction.setCategory(t.getCategory());
        return transactionRepo.save(transaction);
    }

    public String deleteByid(int id){
        Transaction transaction = transactionRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Transaction","id",id));
        transactionRepo.deleteById(id);
        return "transaction deleted...";
    }


}
