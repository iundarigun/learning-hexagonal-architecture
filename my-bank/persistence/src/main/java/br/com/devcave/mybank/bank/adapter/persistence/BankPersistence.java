package br.com.devcave.mybank.bank.adapter.persistence;

import br.com.devcave.mybank.bank.domain.Bank;
import br.com.devcave.mybank.bank.port.out.CreateBankPort;
import br.com.devcave.mybank.bank.port.out.LoadBankPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BankPersistence implements CreateBankPort, LoadBankPort {

    private final BankRepository bankRepository;

    @Override
    public boolean existsBankWithNameOrIban(String name, String iban) {
        return bankRepository.existsByNameOrIban(name, iban);
    }

    @Override
    public Long createBank(Bank bank) {
        final BankEntity entity = BankEntity.builder()
                .name(bank.getName())
                .iban(bank.getIban())
                .build();

        return bankRepository.save(entity).getId();
    }

    @Override
    public Optional<Bank> retrieveBank(final Long id) {
        return bankRepository.findById(id)
                .map(it -> Bank.getBank(it.getId(), it.getName(), it.getIban()));
    }
}
