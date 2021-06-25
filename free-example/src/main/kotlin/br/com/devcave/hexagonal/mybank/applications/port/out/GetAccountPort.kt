package br.com.devcave.hexagonal.mybank.applications.port.out

interface GetAccountPort {
    fun existsAccount(ownerId: Long, bankId: Long): Boolean
}