package br.com.devcave.mybank.exception;

import java.util.List;

public class EntityNotFoundException extends MyBankException {
    public <T> EntityNotFoundException(T clazz) {
        super(List.of("The entity '" + clazz.getClass().getSimpleName() + "' not found!"));
    }
}
