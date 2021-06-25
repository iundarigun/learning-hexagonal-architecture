package br.com.devcave.hexagonal.mybank.adapter.`in`.web.request

data class CreateAccountRequest(
    val bankId: Long,
    val ownerId: Long
)
