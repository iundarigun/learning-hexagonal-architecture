package br.com.devcave.hexagonal.mybank.applications.port.out

import br.com.devcave.hexagonal.mybank.common.Bank

interface GetBankPort {
    fun getBank(bankId: Long): Bank?
}