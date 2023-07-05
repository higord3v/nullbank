package com.nullbank.app.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotEmpty(message = "A rua é obrigatória")
    @Column(name = "street")
    private String street;

    @NotEmpty(message = "O cep é obrigatório")
    @Column(name = "cep")
    private String cep;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @NotNull(message = "O número é obrigatório")
    @Column(name = "adress_number")
    private Integer address_number;

    public Address(String street, String cep, Integer address_number) {
        this.street = street;
        this.cep = cep;
        this.address_number = address_number;
    }

    public Address() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getAddress_number() {
        return address_number;
    }

    public void setAddress_number(Integer address_number) {
        this.address_number = address_number;
    }
}
