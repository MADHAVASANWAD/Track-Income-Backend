package com.finance.repo;

import com.finance.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepo extends JpaRepository<Income,Integer> {
}
