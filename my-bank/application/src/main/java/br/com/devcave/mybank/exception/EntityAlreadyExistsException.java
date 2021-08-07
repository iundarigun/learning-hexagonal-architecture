package br.com.devcave.mybank.exception;

import java.util.List;

public class EntityAlreadyExistsException extends MyBankException {
    public <T> EntityAlreadyExistsException(T clazz) {
        super(List.of("The entity '" + clazz.getClass().getSimpleName() + "' already exists"));
    }
}
