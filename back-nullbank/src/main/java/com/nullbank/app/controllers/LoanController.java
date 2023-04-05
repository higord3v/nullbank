package com.nullbank.app.controllers;

import com.nullbank.app.dtos.LoanDTO;
import com.nullbank.app.exceptions.CustomerNotFoundException;
import com.nullbank.app.exceptions.LoanNotFoundException;
import com.nullbank.app.exceptions.NotAllowedLoanException;
import com.nullbank.app.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
public class LoanController {

    private LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping("/{cpf}/emprestimos")
    @ResponseStatus(HttpStatus.CREATED)
    public LoanDTO create(@PathVariable String cpf, @Valid @RequestBody LoanDTO dto)
            throws CustomerNotFoundException, NotAllowedLoanException {
        return this.loanService.createLoan(cpf, dto);
    }

    @GetMapping("/{cpf}/emprestimos")
    public List<LoanDTO> index(@PathVariable String cpf) throws CustomerNotFoundException {
        return this.loanService.findAllByCpf(cpf);
    }

    @GetMapping("/{cpf}/emprestimos/{id}")
    public LoanDTO index(@PathVariable String cpf, @PathVariable Long id) throws CustomerNotFoundException, LoanNotFoundException {
        return this.loanService.findByCpfAndId(cpf, id);
    }

    @DeleteMapping("/{cpf}/emprestimos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable String cpf, @PathVariable Long id) throws CustomerNotFoundException, LoanNotFoundException {
        this.loanService.deleteById(cpf, id);
    }
}
