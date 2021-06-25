package br.com.devcave.hexagonal.mybank.adapter.out.persistence

import br.com.devcave.hexagonal.mybank.adapter.out.persistence.entity.BankEntity
import br.com.devcave.hexagonal.mybank.adapter.out.persistence.repository.BankRepository
import br.com.devcave.hexagonal.mybank.applications.port.out.GetBankPort
import br.com.devcave.hexagonal.mybank.common.Bank
import org.springframework.stereotype.Repository

@Repository
class BankPersistence(private val bankRepository: BankRepository) : GetBankPort {

    override fun getBank(bankId: Long): Bank? {
        return bankRepository.findById(bankId)
            .orElse(null)?.toBank()
    }
}

fun BankEntity.toBank() =
    Bank(
        this.id,
        this.name,
        this.iban
    )
