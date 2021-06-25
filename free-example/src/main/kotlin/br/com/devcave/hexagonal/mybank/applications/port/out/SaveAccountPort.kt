package br.com.devcave.hexagonal.mybank.applications.port.out

import br.com.devcave.hexagonal.mybank.common.Account

interface SaveAccountPort {
    fun save(account: Account): Account
}