package com.nullbank.app.services;

import com.nullbank.app.dtos.LoanDTO;
import com.nullbank.app.entities.Customer;
import com.nullbank.app.entities.Loan;
import com.nullbank.app.exceptions.CustomerNotFoundException;
import com.nullbank.app.exceptions.LoanNotFoundException;
import com.nullbank.app.exceptions.NotAllowedLoanException;
import com.nullbank.app.mappers.LoanMapper;
import com.nullbank.app.repositories.CustomerRepository;
import com.nullbank.app.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class LoanService {

    private LoanRepository loanRepository;
    private CustomerRepository customerRepository;
    private LoanMapper loanMapper;

    @Autowired
    public LoanService(LoanRepository loanRepository, CustomerRepository customerRepository, LoanMapper loanMapper) {
        this.loanRepository = loanRepository;
        this.customerRepository = customerRepository;
        this.loanMapper = loanMapper;
    }

    public LoanDTO createLoan(String cpf, LoanDTO dto) throws CustomerNotFoundException, NotAllowedLoanException {
        Customer customer = this.customerRepository.findByCpf(cpf);

        if (customer == null) {
            throw new CustomerNotFoundException(cpf);
        }

        BigDecimal customerMonthlyIncome = customer.getMonthly_income();
        BigDecimal limitValueForLoan = customerMonthlyIncome.multiply(new BigDecimal(10));

        List<Loan> customerLoans = customer.getLoans();
        BigDecimal loansSum = customerLoans.stream()
                .map(x -> x.getInitial_amount())
                .reduce(dto.getInitial_amount(), BigDecimal::add);

        int validIncomeCompare = loansSum.compareTo(limitValueForLoan);

        if (validIncomeCompare == 1) {
            throw new NotAllowedLoanException();
        }

        Date startDate = new Date();
        Date endDate = new Date();

        int loansAmount = customer.getLoans().size();
        BigDecimal finalAmount = customer.calculateLoan(dto.getInitial_amount(), loansAmount);

        Loan loan = new Loan(
                customer,
                dto.getInitial_amount(),
                finalAmount,
                startDate,
                endDate
        );

        return this.loanMapper
                .loanToLoanDTO(
                        this.loanRepository
                                .save(loan)
                );
    }

    public List<LoanDTO> findAllByCpf(String cpf) throws CustomerNotFoundException {
        Customer customer = this.customerRepository.findByCpf(cpf);
        if (customer == null) {
            throw new CustomerNotFoundException(cpf);
        }

        return this.loanMapper.loanListToLoanDTOList(
                this.loanRepository
                        .findAllByCustomer_Cpf(cpf)
        );
    }

    public LoanDTO findByCpfAndId(String cpf, Long id) throws CustomerNotFoundException, LoanNotFoundException {
        Customer customer = this.customerRepository
                .findByCpf(cpf);

        if (customer == null) {
            throw new CustomerNotFoundException(cpf);
        }

        Loan loan = this.loanRepository
                .findById(id)
                .orElseThrow(() -> new LoanNotFoundException(id));

        return this.loanMapper
                .loanToLoanDTO(loan);
    }


    public void deleteById(String cpf, Long id) throws CustomerNotFoundException, LoanNotFoundException {
        Customer customer = this.customerRepository
                .findByCpf(cpf);

        if (customer == null) {
            throw new CustomerNotFoundException(cpf);
        }

        this.loanRepository
                .findById(id)
                .orElseThrow(() -> new LoanNotFoundException(id));

        this.loanRepository.deleteById((id));
    }
}
