package br.com.devcave.hexagonal.mybank.common

import java.math.BigDecimal

data class Account(
    val id: Long,
    val bank: Bank,
    val owner: Customer,
    val amount: BigDecimal
)
