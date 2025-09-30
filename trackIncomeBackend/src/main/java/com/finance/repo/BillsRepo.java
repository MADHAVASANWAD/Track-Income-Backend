package com.finance.repo;

import com.finance.model.Bills;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillsRepo extends JpaRepository<Bills,Long> {
}
