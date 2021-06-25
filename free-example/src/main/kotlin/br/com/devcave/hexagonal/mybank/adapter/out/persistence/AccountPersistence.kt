package br.com.devcave.hexagonal.mybank.adapter.out.persistence

import br.com.devcave.hexagonal.mybank.adapter.out.persistence.entity.AccountEntity
import br.com.devcave.hexagonal.mybank.adapter.out.persistence.repository.AccountRepository
import br.com.devcave.hexagonal.mybank.adapter.out.persistence.repository.BankRepository
import br.com.devcave.hexagonal.mybank.adapter.out.persistence.repository.CustomerRepository
import br.com.devcave.hexagonal.mybank.applications.port.out.GetAccountPort
import br.com.devcave.hexagonal.mybank.applications.port.out.SaveAccountPort
import br.com.devcave.hexagonal.mybank.common.Account
import org.springframework.stereotype.Repository

@Repository
class AccountPersistence(
    private val bankRepository: BankRepository,
    private val customerRepository: CustomerRepository,
    private val accountRepository: AccountRepository
) : GetAccountPort, SaveAccountPort {
    override fun existsAccount(ownerId: Long, bankId: Long): Boolean {
        return accountRepository.existsByOwnerIdAndBankId(ownerId, bankId)
    }

    override fun save(account: Account): Account {
        val entity = accountRepository.save(
            AccountEntity(
                bank = bankRepository.findById(account.bank.id).get(),
                owner = customerRepository.findById(account.owner.id).get()
            )
        )
        return entity.toAccount()
    }
}

private fun AccountEntity.toAccount(): Account =
    Account(
        this.id,
        this.bank.toBank(),
        this.owner.toCustomer(),
        this.amount
    )
