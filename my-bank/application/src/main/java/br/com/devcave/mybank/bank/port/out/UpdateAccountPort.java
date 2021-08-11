package br.com.devcave.mybank.bank.port.out;

import br.com.devcave.mybank.bank.domain.Account;
import br.com.devcave.mybank.bank.domain.LockedEntity;

public interface UpdateAccountPort {
    void updateAccount(LockedEntity<Account> account);
}
