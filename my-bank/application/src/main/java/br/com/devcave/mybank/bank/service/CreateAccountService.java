package br.com.devcave.mybank.bank.service;

import br.com.devcave.mybank.bank.domain.Account;
import br.com.devcave.mybank.bank.domain.Bank;
import br.com.devcave.mybank.bank.port.in.CreateAccountCommand;
import br.com.devcave.mybank.bank.port.in.CreateAccountUseCase;
import br.com.devcave.mybank.bank.port.out.CreateAccountPort;
import br.com.devcave.mybank.bank.port.out.LoadBankPort;
import br.com.devcave.mybank.bank.port.out.LoadCustomerPort;
import br.com.devcave.mybank.customer.domain.Customer;
import br.com.devcave.mybank.exception.EntityAlreadyExistsException;
import br.com.devcave.mybank.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
class CreateAccountService implements CreateAccountUseCase {

    private final CreateAccountPort createAccountPort;

    private final LoadBankPort loadBankPort;

    private final LoadCustomerPort loadCustomerPort;

    @Override
    @Transactional
    public Long createAccount(final CreateAccountCommand command) {
        // validate Account
        if (createAccountPort.existsAccountByBankAndCustomer(command.getBankId(), command.getOwnerId())) {
            throw new EntityAlreadyExistsException(Account.class);
        }

        loadBankPort.retrieveBank(command.getBankId())
                .orElseThrow(() -> new EntityNotFoundException(Bank.class));

        loadCustomerPort.retrieveCustomer(command.getOwnerId())
                .orElseThrow(() -> new EntityNotFoundException(Customer.class));

        // create Account
        final Account newAccount = Account.newAccount(command.getBankId(), command.getOwnerId());

        return createAccountPort.createAccount(newAccount);
    }
}
