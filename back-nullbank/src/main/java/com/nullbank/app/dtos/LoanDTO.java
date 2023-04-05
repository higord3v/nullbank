package com.nullbank.app.dtos;

import java.math.BigDecimal;
import java.util.Date;

public class LoanDTO {
    private long id;

    private BigDecimal initial_amount;

    private BigDecimal final_amount;

    private Date start_date;

    private Date end_date;

    public LoanDTO(
            BigDecimal initial_amount,
            BigDecimal final_amount,
            Date start_date,
            Date end_date) {
        this.initial_amount = initial_amount;
        this.final_amount = final_amount;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public LoanDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
