package com.nullbank.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends Exception {

    public CustomerNotFoundException(String cpf) {
        super(String.format("O cliente com CPF %s não foi encontrado", cpf));
    }

}