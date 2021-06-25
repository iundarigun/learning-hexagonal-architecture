package br.com.devcave.hexagonal.mybank.adapter.out.persistence.repository

import br.com.devcave.hexagonal.mybank.adapter.out.persistence.entity.BankEntity
import org.springframework.data.repository.CrudRepository

interface BankRepository : CrudRepository<BankEntity, Long>