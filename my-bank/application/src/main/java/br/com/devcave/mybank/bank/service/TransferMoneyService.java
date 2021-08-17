package br.com.devcave.mybank.bank.service;

import br.com.devcave.mybank.bank.domain.Account;
import br.com.devcave.mybank.bank.domain.DepositMovement;
import br.com.devcave.mybank.bank.domain.LockedEntity;
import br.com.devcave.mybank.bank.domain.Movement;
import br.com.devcave.mybank.bank.domain.TransferMovement;
import br.com.devcave.mybank.bank.port.in.TransferMoneyCommand;
import br.com.devcave.mybank.bank.port.in.TransferMoneyUseCase;
import br.com.devcave.mybank.bank.port.in.WithdrawFromAccountCommand;
import br.com.devcave.mybank.bank.port.in.WithdrawFromAccountUseCase;
import br.com.devcave.mybank.bank.port.out.CreateMovementPort;
import br.com.devcave.mybank.bank.port.out.LoadAccountPort;
import br.com.devcave.mybank.bank.port.out.UpdateAccountPort;
import br.com.devcave.mybank.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TransferMoneyService implements TransferMoneyUseCase {

    private final LoadAccountPort loadAccountPort;

    private final UpdateAccountPort updateAccountPort;

    private final CreateMovementPort createMovementPort;

    @Override
    @Transactional
    public String transferMoney(final TransferMoneyCommand command) {
        final LockedEntity<Account> originAccount = loadAccountPort.getAndLockAccount(command.getAccountOriginId())
                .orElseThrow(() -> new EntityNotFoundException(Account.class));
        final LockedEntity<Account> destinationAccount = loadAccountPort.getAndLockAccount(command.getAccountDestinationId())
                .orElseThrow(() -> new EntityNotFoundException(Account.class));

        originAccount.getEntity().withdraw(command.getAmount());
        destinationAccount.getEntity().deposit(command.getAmount());

        final Movement movement = new TransferMovement(command.getAccountOriginId(), command.getAccountDestinationId(), command.getAmount());

        updateAccountPort.updateAccount(originAccount);
        updateAccountPort.updateAccount(destinationAccount);

        return createMovementPort.createMovement(movement);
    }
}
