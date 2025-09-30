package com.finance.service;

import com.finance.exception.ResourceNotFoundException;
import com.finance.model.Budget;
import com.finance.model.Income;
import com.finance.repo.IncomeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeService {

    @Autowired
    private IncomeRepo income;

    public List<Income> getall() {
        return income.findAll();
    }

    public Income insert(Income t) {
        return income.save(t);
    }

    public Income update(Income t, int id) {
        Income income1 = income.findById(id).orElseThrow(() -> new ResourceNotFoundException("income","id",id));
        income1.setIncome(t.getIncome());
        return income.save(income1);
    }

    public String deleteByid(int id){
        Income income1 = income.findById(id).orElseThrow(() -> new ResourceNotFoundException("income","id",id));
        income.deleteById(id);
        return "transaction deleted...";
    }
}
