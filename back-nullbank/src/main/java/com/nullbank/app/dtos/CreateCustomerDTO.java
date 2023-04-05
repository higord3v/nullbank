package com.nullbank.app.dtos;

import com.nullbank.app.enums.RelationshipEnum;

import java.math.BigDecimal;

public class CreateCustomerDTO {
    private String name;
    private String cpf;
    private BigDecimal monthly_income;
    private String street;
    private Integer address_number;
    private String cep;
    private String phone;
    private RelationshipEnum relationship;

    public CreateCustomerDTO(
            String name,
            String cpf,
            BigDecimal monthly_income,
            String street,
            Integer address_number,
            String cep,
            String phone,
            RelationshipEnum relationship
    ) {
        this.name = name;
        this.cpf = cpf;
        this.monthly_income = monthly_income;
        this.street = street;
        this.address_number = address_number;
        this.cep = cep;
        this.phone = phone;
        this.relationship = relationship;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public BigDecimal getMonthly_income() {
        return monthly_income;
    }

    public void setMonthly_income(BigDecimal monthly_income) {
        this.monthly_income = monthly_income;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getAddress_number() {
        return address_number;
    }

    public void setAddress_number(Integer address_number) {
        this.address_number = address_number;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public RelationshipEnum getRelationship() {
        return relationship;
    }

    public void setRelationship(RelationshipEnum relationship) {
        this.relationship = relationship;
    }
}
