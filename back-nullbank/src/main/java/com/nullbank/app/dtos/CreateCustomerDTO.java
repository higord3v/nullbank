package com.nullbank.app.dtos;

public class CreateCustomerDTO {
    private String name;
    private String cpf;
    private Integer monthly_income;
    private String street;
    private Integer address_number;
    private String cep;
    private String phone;

    public CreateCustomerDTO(String name, String cpf, Integer monthly_income, String street, Integer address_number, String cep, String phone) {
        this.name = name;
        this.cpf = cpf;
        this.monthly_income = monthly_income;
        this.street = street;
        this.address_number = address_number;
        this.cep = cep;
        this.phone = phone;
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

    public Integer getMonthly_income() {
        return monthly_income;
    }

    public void setMonthly_income(Integer monthly_income) {
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
}
