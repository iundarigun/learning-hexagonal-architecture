package br.com.devcave.mybank.bank.port.out;

import br.com.devcave.mybank.bank.domain.Account;
import br.com.devcave.mybank.bank.domain.LockedEntity;

import java.util.Optional;

public interface LoadAccountPort {
    Optional<? extends LockedEntity<Account>> getAndLockAccount(Long id);
}
