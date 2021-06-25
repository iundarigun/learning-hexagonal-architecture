package br.com.devcave.hexagonal.mybank.applications.business

import br.com.devcave.hexagonal.mybank.applications.exception.AlreadyExistsException
import br.com.devcave.hexagonal.mybank.applications.exception.NotFoundException
import br.com.devcave.hexagonal.mybank.applications.port.`in`.CreateAccountUseCase
import br.com.devcave.hexagonal.mybank.applications.port.out.GetAccountPort
import br.com.devcave.hexagonal.mybank.applications.port.out.GetBankPort
import br.com.devcave.hexagonal.mybank.applications.port.out.GetCustomerPort
import br.com.devcave.hexagonal.mybank.applications.port.out.SaveAccountPort
import br.com.devcave.hexagonal.mybank.common.Account
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class AccountService(
    private val getAccountPort: GetAccountPort,
    private val saveAccountPort: SaveAccountPort,
    private val getBankPort: GetBankPort,
    private val getCustomerPort: GetCustomerPort
) : CreateAccountUseCase {

    override fun createAccount(ownerId: Long, bankId: Long): Account {
        if (getAccountPort.existsAccount(ownerId, bankId)) {
            throw AlreadyExistsException()
        }
        val bank = getBankPort.getBank(bankId) ?: throw NotFoundException()
        val owner = getCustomerPort.getCustomer(ownerId) ?: throw NotFoundException()

        return saveAccountPort.save(
            Account(
                0,
                bank,
                owner,
                BigDecimal.ZERO
            )
        )
    }
}