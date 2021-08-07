package br.com.devcave.mybank.exception;

import javax.validation.ConstraintViolation;
import java.util.Set;
import java.util.stream.Collectors;

public class InputValidationException extends MyBankException {
    public <T> InputValidationException( Set<ConstraintViolation<T>> validate) {
        super(validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList()));
    }
}
