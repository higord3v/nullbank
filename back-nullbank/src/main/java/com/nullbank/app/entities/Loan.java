package com.nullbank.app.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "loan")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "customer_cpf")
    private Customer customer;

    @Column(name = "initial_amount")
    @NotNull(message = "O valor inicial é obrigatório")
    private BigDecimal initial_amount;

    @Column(name = "final_amount")
    @NotNull(message = "O valor final é obrigatório")
    private BigDecimal final_amount;

    @Column(name = "start_date")
    private Date start_date;

    @Column(name = "end_date")
    private Date end_date;

    public Loan(
            Customer customer,
            BigDecimal initial_amount,
            BigDecimal final_amount,
            Date start_date,
            Date end_date
    ) {
        this.customer = customer;
        this.initial_amount = initial_amount;
        this.final_amount = final_amount;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public Loan() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BigDecimal getInitial_amount() {
        return initial_amount;
    }

    public void setInitial_amount(BigDecimal initial_amount) {
        this.initial_amount = initial_amount;
    }

    public BigDecimal getFinal_amount() {
        return final_amount;
    }

    public void setFinal_amount(BigDecimal final_amount) {
        this.final_amount = final_amount;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
}
