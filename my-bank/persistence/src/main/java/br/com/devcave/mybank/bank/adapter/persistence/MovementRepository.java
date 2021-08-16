package br.com.devcave.mybank.bank.adapter.persistence;

import org.springframework.data.repository.CrudRepository;

interface MovementRepository extends CrudRepository<MovementEntity, Long> {
}
