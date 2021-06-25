package br.com.devcave.hexagonal.mybank.adapter.out.persistence.repository

import br.com.devcave.hexagonal.mybank.adapter.out.persistence.entity.AccountEntity
import org.springframework.data.repository.CrudRepository

interface AccountRepository : CrudRepository<AccountEntity, Long> {
    fun existsByOwnerIdAndBankId(ownerId: Long, bankId: Long): Boolean
}