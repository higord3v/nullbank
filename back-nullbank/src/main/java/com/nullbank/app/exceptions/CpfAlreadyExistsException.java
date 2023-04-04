package com.nullbank.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CpfAlreadyExistsException extends Exception {

    public CpfAlreadyExistsException(String cpf) {
        super(String.format("O cpf %s já está cadastrado", cpf));
    }

}
