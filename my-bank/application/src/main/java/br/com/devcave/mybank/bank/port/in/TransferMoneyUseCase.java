package br.com.devcave.mybank.bank.port.in;

public interface TransferMoneyUseCase {

    String transferMoney(TransferMoneyCommand command);
}
