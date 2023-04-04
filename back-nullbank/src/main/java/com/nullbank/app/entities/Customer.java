package com.nullbank.app.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotEmpty(message = "O nome é obrigatório")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "O cpf é obrigatório")
    @Column(name = "cpf", unique = true)
    private String cpf;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @NotEmpty(message = "O endereço é obrigatório")
    private List<Address> addresses;

    @NotEmpty(message = "O telefone é obrigatório")
    @Column(name = "phone")
    private String phone;

    @NotNull(message = "O rendimento mensal é obrigatório")
    @Column(name = "monthly_income")
    private Integer monthly_income;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Loan> loans;


    public Customer(String name, String cpf, String phone, Integer monthly_income, List<Address> addresses) {
        this.name = name;
        this.cpf = cpf;
        this.phone = phone;
        this.monthly_income = monthly_income;
        this.addresses = addresses;
    }

    public Customer() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<Address> getAddress() {
        return addresses;
    }

    public void setAddress(List<Address> address) {
        this.addresses = address;
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
