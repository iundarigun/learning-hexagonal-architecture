package br.com.devcave.mybank.bank.port.out;

import br.com.devcave.mybank.bank.domain.Bank;

public interface CreateBankPort {
    boolean existsBankWithNameOrIban(String name, String iban);

    Long createBank(Bank bank);
}
