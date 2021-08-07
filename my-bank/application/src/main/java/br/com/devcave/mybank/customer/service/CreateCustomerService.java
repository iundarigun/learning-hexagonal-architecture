package br.com.devcave.mybank.customer.service;

import br.com.devcave.mybank.customer.domain.Customer;
import br.com.devcave.mybank.customer.port.in.CreateCustomerCommand;
import br.com.devcave.mybank.customer.port.in.CreateCustomerUseCase;
import br.com.devcave.mybank.customer.port.out.CreateCustomerPort;
import br.com.devcave.mybank.exception.EntityAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
class CreateCustomerService implements CreateCustomerUseCase {

    private final CreateCustomerPort createCustomerPort;

    @Override
    @Transactional
    public Long createCustomer(final CreateCustomerCommand command) {
        // Validate if exists
        if (createCustomerPort.existsCustomerWithDocument(command.getDocument())) {
            throw new EntityAlreadyExistsException(Customer.class);
        }
        // Create Customer
        final Customer newCustomer = Customer.newCustomer(command.getName(), command.getDocument());

        return createCustomerPort.createCustomer(newCustomer);
    }
}
