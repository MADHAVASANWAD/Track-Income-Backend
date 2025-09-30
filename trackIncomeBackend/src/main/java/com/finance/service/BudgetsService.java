package com.finance.service;

import com.finance.exception.ResourceNotFoundException;
import com.finance.model.Budget;
import com.finance.repo.BudgetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetsService {
    @Autowired
    private BudgetRepo budgetRepo;

    public List<Budget> getall() {
        return budgetRepo.findAll();
    }

    public Budget insert(Budget t) {
        return budgetRepo.save(t);
    }

    public Budget update(Budget t, int id) {
        Budget budget1 = budgetRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("budget","id",id));
        budget1.setCategory(t.getCategory());
        budget1.setColor(t.getColor());
        budget1.setLimit(t.getLimit());
        return budgetRepo.save(budget1);
    }

    public String deleteByid(int id){
        Budget budget = budgetRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("budget","id",id));
        budgetRepo.deleteById(id);
        return "transaction deleted...";
    }
}
