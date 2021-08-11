package br.com.devcave.mybank.bank.port.out;

import br.com.devcave.mybank.bank.domain.Account;

public interface CreateAccountPort {
    boolean existsAccountByBankAndCustomer(Long bankId, Long customerId);

    Long createAccount(Account account);
}
