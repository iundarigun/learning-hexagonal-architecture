package br.com.devcave.mybank.customer.adapter.persistence;

import org.springframework.data.repository.CrudRepository;

interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {
    boolean existsByDocument(String document);
}
