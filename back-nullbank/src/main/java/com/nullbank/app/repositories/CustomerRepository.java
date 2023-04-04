package com.nullbank.app.repositories;

import com.nullbank.app.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByCpf(String cpf);
    void deleteByCpf(String cpf);
}
