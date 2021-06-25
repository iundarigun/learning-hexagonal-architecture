package br.com.devcave.hexagonal.mybank.adapter.out.persistence.repository

import br.com.devcave.hexagonal.mybank.adapter.out.persistence.entity.CustomerEntity
import org.springframework.data.repository.CrudRepository

interface CustomerRepository : CrudRepository<CustomerEntity, Long>