package br.com.devcave.mybank.bank.port.in;

public interface CreateAccountUseCase {

    Long createAccount(CreateAccountCommand command);
}
