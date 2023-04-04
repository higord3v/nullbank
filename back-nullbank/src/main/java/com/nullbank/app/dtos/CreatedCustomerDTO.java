package com.nullbank.app.dtos;

public class CreatedCustomerDTO {
    private String name;
    private String cpf;
    private Integer monthly_income;
    private String phone;

    public CreatedCustomerDTO(String name, String cpf, Integer monthly_income, String phone) {
        this.name = name;
        this.cpf = cpf;
        this.monthly_income = monthly_income;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
