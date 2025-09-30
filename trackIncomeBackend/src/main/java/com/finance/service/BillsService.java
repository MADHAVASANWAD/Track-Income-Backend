package com.finance.service;

import com.finance.exception.ResourceNotFoundException;
import com.finance.model.Bills;
import com.finance.model.Transaction;
import com.finance.repo.BillsRepo;
import com.finance.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillsService {

    @Autowired
    private BillsRepo billsRepo;

    public List<Bills> getall() {
        return billsRepo.findAll();
    }

    public Bills insert(Bills t) {
        return billsRepo.save(t);
    }

    public Bills update(Bills t, long id) {
        Bills bills = billsRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("bill","id",id));
        bills.setAmount(t.getAmount());
        bills.setTitle(t.getTitle());
        bills.setDuedate(t.getDuedate());
        return billsRepo.save(bills);
    }

    public String deleteByid(long id){
        Bills Bills = billsRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("bill","id",id));
        billsRepo.deleteById(id);
        return "transaction deleted...";
    }

}
