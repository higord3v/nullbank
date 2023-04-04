package com.nullbank.app.dtos;

import com.nullbank.app.entities.Address;

public class CustomerDTO {
    private String name;
    private String cpf;

    private String phone;

    private Integer monthly_income;

    public CustomerDTO(
            String name,
            String cpf,
            String phone,
            Integer monthly_income
    ) {
        this.name = name;
        this.cpf = cpf;
        this.phone = phone;
        this.monthly_income = monthly_income;
    }

    public CustomerDTO() {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getMonthly_income() {
        return monthly_income;
    }

    public void setMonthly_income(Integer monthly_income) {
        this.monthly_income = monthly_income;
    }
}
