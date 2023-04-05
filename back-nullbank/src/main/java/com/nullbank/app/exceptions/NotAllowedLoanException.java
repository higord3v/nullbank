package com.nullbank.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class NotAllowedLoanException extends Exception{
    public NotAllowedLoanException() {
        super(String.format("O valor do empréstimo está acima do limite permitido"));
    }
}
