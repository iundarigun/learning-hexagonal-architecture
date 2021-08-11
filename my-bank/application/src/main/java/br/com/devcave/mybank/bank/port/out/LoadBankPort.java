package br.com.devcave.mybank.bank.port.out;

import br.com.devcave.mybank.bank.domain.Bank;

import java.util.Optional;

public interface LoadBankPort {
    Optional<Bank> retrieveBank(Long id);
}
