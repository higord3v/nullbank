package com.nullbank.app.services;

import com.nullbank.app.dtos.CreateCustomerDTO;
import com.nullbank.app.dtos.CreatedCustomerDTO;
import com.nullbank.app.entities.Address;
import com.nullbank.app.entities.Customer;
import com.nullbank.app.exceptions.CpfAlreadyExistsException;
import com.nullbank.app.exceptions.CustomerNotFoundException;
import com.nullbank.app.mappers.CustomerMapper;
import com.nullbank.app.repositories.AddressRepository;
import com.nullbank.app.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    private AddressRepository addressRepository;
    private CustomerMapper customerMapper;

    @Autowired
    public CustomerService(
            CustomerRepository customerRepository,
            AddressRepository addressRepository,
            CustomerMapper customerMapper
    ) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
        this.customerMapper = customerMapper;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public CreatedCustomerDTO createCustomer(CreateCustomerDTO dto) throws CpfAlreadyExistsException {
            Customer isAlreadyRegistered = this.customerRepository
                    .findByCpf(dto.getCpf());
            if (isAlreadyRegistered != null) {
                throw new CpfAlreadyExistsException(isAlreadyRegistered.getCpf());
            }

            Address newAddress = new Address(
                    dto.getStreet(),
                    dto.getCep(),
                    dto.getAddress_number()
                    );

            List<Address> customerAddresses = new ArrayList<Address>();
            customerAddresses.add(newAddress);

            Customer newCustomer = new Customer(
                    dto.getName(),
                    dto.getCpf(),
                    dto.getPhone(),
                    dto.getMonthly_income(),
                    customerAddresses
            );

            newAddress.setCustomer(newCustomer);
            this.addressRepository.save(newAddress);
                return this.customerMapper
                        .INSTANCE
                        .customerToCreatedCustomerDTO(
                                this.customerRepository
                                        .save(newCustomer)
                        );
    }

    public List<CreatedCustomerDTO> findAllCustomers() {
        return this.customerMapper
                .customerListToCreatedCustomerDTOList(
                        this.customerRepository
                                .findAll()
                );
    }

    public CreatedCustomerDTO findOneCustomer(String cpf) throws CustomerNotFoundException {
        CreatedCustomerDTO customerDTO = this.customerMapper
                .customerToCreatedCustomerDTO(
                        this.customerRepository
                                .findByCpf(cpf)
                );

        if (customerDTO == null) {
            throw new CustomerNotFoundException(cpf);
        }

        return customerDTO;
    }

    @Transactional
    public void deleteCustomer(String cpf) throws CustomerNotFoundException {
        Customer customer = this.customerRepository
                                .findByCpf(cpf);

        if (customer == null) {
            throw new CustomerNotFoundException(cpf);
        }

        this.customerRepository.deleteByCpf(cpf);
    }

    public CreatedCustomerDTO updateCustomer(String cpf, CreateCustomerDTO dto)
            throws CpfAlreadyExistsException, CustomerNotFoundException {

        Customer customer = this.customerRepository.findByCpf(cpf);

        if (customer == null) {
            throw new CustomerNotFoundException(cpf);
        }

        Customer cpfArealdyRegistered = this.customerRepository.findByCpf(dto.getCpf());

        if (cpfArealdyRegistered != null && cpfArealdyRegistered.getCpf() != customer.getCpf()) {
            throw new CpfAlreadyExistsException(cpf);
        }

        if (dto.getCpf() != null) {
            customer.setCpf(dto.getCpf());
        }

        if (dto.getName() != null) {
            customer.setName(dto.getName());
        }

        if (dto.getPhone() != null) {
            customer.setPhone(dto.getPhone());
        }

        if (dto.getMonthly_income() != null) {
            customer.setMonthly_income(dto.getMonthly_income());
        }

        return this.customerMapper
                .customerToCreatedCustomerDTO(
                        this.customerRepository.save(customer)
                );
    }
}
