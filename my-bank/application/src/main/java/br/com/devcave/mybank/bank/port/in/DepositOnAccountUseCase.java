package br.com.devcave.mybank.bank.port.in;

public interface DepositOnAccountUseCase {

    String depositOnAccount(DepositOnAccountCommand command);
}
