package br.com.devcave.mybank.customer.adapter.persistence;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {
    boolean existsByDocument(String document);
}
