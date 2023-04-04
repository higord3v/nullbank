package com.nullbank.app.controllers;

import com.nullbank.app.dtos.CreateCustomerDTO;
import com.nullbank.app.dtos.CreatedCustomerDTO;
import com.nullbank.app.exceptions.CpfAlreadyExistsException;
import com.nullbank.app.exceptions.CustomerNotFoundException;
import com.nullbank.app.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
public class CustomerController {
    private CustomerService customerService;

    CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public CreatedCustomerDTO create(@Valid @RequestBody CreateCustomerDTO dto) throws CpfAlreadyExistsException {
        return this.customerService.createCustomer(dto);
    }

    @GetMapping
    public List<CreatedCustomerDTO> index() {
        return this.customerService.findAllCustomers();
    }

    @GetMapping("/{cpf}")
    public CreatedCustomerDTO show(@Valid @PathVariable String cpf) throws CustomerNotFoundException {
        return this.customerService.findOneCustomer(cpf);
    }

    @PutMapping("/{cpf}")
    public CreatedCustomerDTO update(
            @Valid @PathVariable String cpf,
            @RequestBody CreateCustomerDTO dto
    ) throws CpfAlreadyExistsException, CustomerNotFoundException {
        return this.customerService.updateCustomer(cpf, dto);
    }

    @DeleteMapping("/{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@Valid @PathVariable String cpf) throws CustomerNotFoundException {
        this.customerService.deleteCustomer(cpf);
    }
}
