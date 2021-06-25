package br.com.devcave.hexagonal.mybank.applications.port.`in`

import br.com.devcave.hexagonal.mybank.common.Account

interface CreateAccountUseCase {

    fun createAccount(ownerId: Long, bankId: Long): Account
}