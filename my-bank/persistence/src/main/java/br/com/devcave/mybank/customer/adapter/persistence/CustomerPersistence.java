package br.com.devcave.mybank.customer.adapter.persistence;

import br.com.devcave.mybank.customer.domain.Customer;
import br.com.devcave.mybank.customer.port.out.CreateCustomerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerPersistence implements CreateCustomerPort {

    private final CustomerRepository customerRepository;

    @Override
    public boolean existsCustomerWithDocument(String document) {
        return customerRepository.existsByDocument(document);
    }

    @Override
    public Long createCustomer(Customer customer) {
        final CustomerEntity entity = CustomerEntity.builder()
                .name(customer.getName())
                .document(customer.getDocument())
                .build();

        return customerRepository.save(entity).getId();
    }
}

