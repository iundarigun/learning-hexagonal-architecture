package br.com.devcave.mybank.bank.adapter.persistence;

import br.com.devcave.mybank.bank.domain.Account;
import br.com.devcave.mybank.bank.domain.LockedEntity;
import br.com.devcave.mybank.bank.port.out.CreateAccountPort;
import br.com.devcave.mybank.bank.port.out.LoadAccountPort;
import br.com.devcave.mybank.bank.port.out.UpdateAccountPort;
import br.com.devcave.mybank.customer.adapter.persistence.CustomerEntity;
import br.com.devcave.mybank.entity.LockedEntityImpl;
import br.com.devcave.mybank.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AccountPersistence implements CreateAccountPort, LoadAccountPort, UpdateAccountPort {

    private final AccountRepository accountRepository;

    @Override
    public boolean existsAccountByBankAndCustomer(final Long bankId, final Long customerId) {
        return accountRepository.existsByBankIdAndOwnerId(bankId, customerId);
    }

    @Override
    public Long createAccount(final Account account) {
        final AccountEntity entity = AccountEntity.builder()
                .bank(BankEntity.builder().id(account.getBankId()).build())
                .owner(CustomerEntity.builder().id(account.getOwnerId()).build())
                .build();

        return accountRepository.save(entity).getId();
    }

    @Override
    public Optional<? extends LockedEntity<Account>> getAndLockAccount(final Long id) {
        return accountRepository.findById(id)
                .map(it -> {
                    final Account account = Account.of(
                            it.getId(), it.getBank().getId(), it.getOwner().getId(), it.getAmount().doubleValue()
                    );
                    return new LockedEntityImpl<>(account, it.getVersion());
                });
    }

    @Override
    public void updateAccount(final LockedEntity<Account> account) {
        if (!(account instanceof LockedEntityImpl)) {
            throw new IllegalArgumentException();
        }
        final AccountEntity entity = accountRepository.findById(account.getEntity().getId())
                .orElseThrow(() -> new EntityNotFoundException(Account.class));

        if (entity.getVersion().compareTo(((LockedEntityImpl<Account>) account).getVersion()) != 0) {
            throw new UnsupportedOperationException();
        }

        entity.setAmount(BigDecimal.valueOf(account.getEntity().getMoney()));
        accountRepository.save(entity);
    }
}
