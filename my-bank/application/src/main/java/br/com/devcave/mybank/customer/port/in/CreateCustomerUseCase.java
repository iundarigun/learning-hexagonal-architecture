package br.com.devcave.mybank.customer.port.in;

public interface CreateCustomerUseCase {

    Long createCustomer(CreateCustomerCommand command);
}
