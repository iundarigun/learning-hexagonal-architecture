package br.com.devcave.mybank.exception;

import lombok.Getter;

import java.util.List;

public abstract class MyBankException extends RuntimeException {

    @Getter
    private final List<String> errorList;

    protected MyBankException(final List<String> errorList) {
        this("Error on bank", errorList);
    }

    protected MyBankException(String message, final List<String> errorList) {
        super(message);
        this.errorList = errorList;
    }

}
