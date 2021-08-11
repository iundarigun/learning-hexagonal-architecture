package br.com.devcave.mybank.bank.port.out;

import br.com.devcave.mybank.customer.domain.Customer;

import java.util.Optional;

public interface LoadCustomerPort {
    Optional<Customer> retrieveCustomer(Long id);
}
