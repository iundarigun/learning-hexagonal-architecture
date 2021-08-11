package br.com.devcave.mybank.bank.adapter.persistence;

import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<AccountEntity, Long> {
    boolean existsByBankIdAndOwnerId(Long bankId, Long customerId);
}
