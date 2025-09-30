package com.finance.repo;

import com.finance.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetRepo extends JpaRepository<Budget,Integer> {
}
