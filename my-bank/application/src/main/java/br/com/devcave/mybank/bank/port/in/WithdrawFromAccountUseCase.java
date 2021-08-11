package br.com.devcave.mybank.bank.port.in;

public interface WithdrawFromAccountUseCase {

    String withdrawFromAccount(WithdrawFromAccountCommand command);
}
