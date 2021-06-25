package br.com.devcave.hexagonal.mybank.common

data class Customer(
    val id: Long,
    val name: String,
    val nationalIdentifier: String
)
