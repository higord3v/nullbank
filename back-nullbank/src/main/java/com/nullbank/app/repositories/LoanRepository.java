package com.nullbank.app.repositories;

import com.nullbank.app.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findAllByCustomer_Cpf(String cpf);
}
