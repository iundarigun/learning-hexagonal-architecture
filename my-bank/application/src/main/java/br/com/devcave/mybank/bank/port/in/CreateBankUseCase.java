package br.com.devcave.mybank.bank.port.in;

public interface CreateBankUseCase {

    Long createBank(CreateBankCommand command);
}
