package br.com.devcave.mybank.customer.port.out;

import br.com.devcave.mybank.customer.domain.Customer;

public interface CreateCustomerPort {
    boolean existsCustomerWithDocument(String document);

    Long createCustomer(Customer customer);
}
