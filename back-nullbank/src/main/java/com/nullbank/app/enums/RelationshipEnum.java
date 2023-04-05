package com.nullbank.app.enums;

import java.math.BigDecimal;

public enum RelationshipEnum {
    GOLD(){
        @Override
        public BigDecimal calculateLoan(BigDecimal initial_amount, int loans) {
            if (loans > 1) {
                return initial_amount.multiply(new BigDecimal("1.3"));
            }
            return initial_amount.multiply(new BigDecimal("1.2"));
        }
    },
    SILVER(){
        @Override
        public BigDecimal calculateLoan(BigDecimal initial_amount, int loans) {
            int compareResult = initial_amount.compareTo(new BigDecimal("5000"));
            if (compareResult == 1) {
                return initial_amount.multiply(new BigDecimal("1.4"));
            }
            return initial_amount.multiply(new BigDecimal("1.6"));
        }
    },
    BRONZE(){
        @Override
        public BigDecimal calculateLoan(BigDecimal initial_amount, int loans) {
            return initial_amount.multiply(new BigDecimal("1.8"));
        }
    };

    public abstract BigDecimal calculateLoan(BigDecimal initial_amount, int loans);
}
