package br.com.devcave.mybank.exception;

import java.util.List;

public class OperationNotAllowedException extends MyBankException {
    public OperationNotAllowedException() {
        super(List.of("Invalid operation! This operation is not allowed with these parameters"));
    }
}
