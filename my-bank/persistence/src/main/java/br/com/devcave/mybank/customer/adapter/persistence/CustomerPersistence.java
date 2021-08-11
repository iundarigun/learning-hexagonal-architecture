package br.com.devcave.mybank.customer.adapter.persistence;

import br.com.devcave.mybank.bank.port.out.LoadCustomerPort;
import br.com.devcave.mybank.customer.domain.Customer;
import br.com.devcave.mybank.customer.port.out.CreateCustomerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CustomerPersistence implements CreateCustomerPort, LoadCustomerPort {

    private final CustomerRepository customerRepository;

    @Override
    public boolean existsCustomerWithDocument(final String document) {
        return customerRepository.existsByDocument(document);
    }

    @Override
    public Long createCustomer(final Customer customer) {
        final CustomerEntity entity = CustomerEntity.builder()
                .name(customer.getName())
                .document(customer.getDocument())
                .build();

        return customerRepository.save(entity).getId();
    }

    @Override
    public Optional<Customer> retrieveCustomer(final Long id) {
        return customerRepository.findById(id)
                .map(it -> Customer.getCustomer(it.getId(), it.getName(), it.getDocument()));
    }
}

