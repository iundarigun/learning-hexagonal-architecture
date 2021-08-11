package br.com.devcave.mybank.bank.adapter.persistence;

import org.springframework.data.repository.CrudRepository;

public interface BankRepository extends CrudRepository<BankEntity, Long> {
    boolean existsByNameOrIban(String name, String iban);
}
