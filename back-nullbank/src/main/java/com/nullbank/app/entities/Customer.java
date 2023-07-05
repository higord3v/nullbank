package com.nullbank.app.entities;

import com.nullbank.app.enums.RelationshipEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
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
    @Column(name = "monthly_income", nullable = false)
    private BigDecimal monthly_income;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Loan> loans;

    @Column(name = "relationship")
    @NotNull(message = "O relacionamento é obrigatório")
    private RelationshipEnum relationship;

    public Customer(String name, String cpf, String phone, BigDecimal monthly_income, List<Address> addresses, RelationshipEnum relationship) {
        this.name = name;
        this.cpf = cpf;
        this.phone = phone;
        this.monthly_income = monthly_income;
        this.addresses = addresses;
        this.relationship = relationship;
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

    public BigDecimal getMonthly_income() {
        return monthly_income;
    }

    public void setMonthly_income(BigDecimal monthly_income) {
        this.monthly_income = monthly_income;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    public RelationshipEnum getRelationship() {
        return this.relationship;
    }

    public void setRelationship(RelationshipEnum relationship) {
        this.relationship = relationship;
    }

    public BigDecimal calculateLoan(BigDecimal initialValue, int loansAmount) {
        return this.relationship.calculateLoan(initialValue, loansAmount);
    }
}
