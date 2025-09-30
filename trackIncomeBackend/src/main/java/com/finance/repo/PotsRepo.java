package com.finance.repo;

import com.finance.model.Pots;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PotsRepo extends JpaRepository<Pots,Long> {
}
