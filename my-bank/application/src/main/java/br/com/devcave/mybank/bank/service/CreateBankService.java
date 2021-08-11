package br.com.devcave.mybank.bank.service;

import br.com.devcave.mybank.bank.domain.Bank;
import br.com.devcave.mybank.bank.port.in.CreateBankCommand;
import br.com.devcave.mybank.bank.port.in.CreateBankUseCase;
import br.com.devcave.mybank.bank.port.out.CreateBankPort;
import br.com.devcave.mybank.exception.EntityAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
class CreateBankService implements CreateBankUseCase {

    private final CreateBankPort createBankPort;

    @Override
    @Transactional
    public Long createBank(final CreateBankCommand command) {
        // validate name and iban
        if (createBankPort.existsBankWithNameOrIban(command.getName(), command.getIban())) {
            throw new EntityAlreadyExistsException(Bank.class);
        }
        // create bank
        final Bank newBank = Bank.newBank(command.getName(), command.getIban());

        return createBankPort.createBank(newBank);
    }
}
