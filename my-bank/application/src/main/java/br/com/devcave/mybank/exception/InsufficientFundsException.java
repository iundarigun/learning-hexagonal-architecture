package br.com.devcave.mybank.exception;

import java.util.List;

public class InsufficientFundsException extends MyBankException {
    public InsufficientFundsException() {
        super(List.of("Insufficients funds for this operation!"));
    }
}
