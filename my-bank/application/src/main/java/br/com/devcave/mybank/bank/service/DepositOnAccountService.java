package br.com.devcave.mybank.bank.service;

import br.com.devcave.mybank.bank.domain.Account;
import br.com.devcave.mybank.bank.domain.DepositMovement;
import br.com.devcave.mybank.bank.domain.LockedEntity;
import br.com.devcave.mybank.bank.domain.Movement;
import br.com.devcave.mybank.bank.port.in.DepositOnAccountCommand;
import br.com.devcave.mybank.bank.port.in.DepositOnAccountUseCase;
import br.com.devcave.mybank.bank.port.out.CreateMovementPort;
import br.com.devcave.mybank.bank.port.out.LoadAccountPort;
import br.com.devcave.mybank.bank.port.out.UpdateAccountPort;
import br.com.devcave.mybank.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DepositOnAccountService implements DepositOnAccountUseCase {

    private final LoadAccountPort loadAccountPort;

    private final UpdateAccountPort updateAccountPort;

    private final CreateMovementPort createMovementPort;

    @Override
    @Transactional
    public String depositOnAccount(final DepositOnAccountCommand command) {
        final LockedEntity<Account> account = loadAccountPort.getAndLockAccount(command.getAccountId())
                .orElseThrow(() -> new EntityNotFoundException(Account.class));

        account.getEntity().deposit(command.getAmount());

        final Movement movement = new DepositMovement(command.getAccountId(), command.getAmount());

        updateAccountPort.updateAccount(account);

        return createMovementPort.createMovement(movement);
    }
}
