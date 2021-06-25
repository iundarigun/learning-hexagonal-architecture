package br.com.devcave.hexagonal.mybank.applications.port.out

import br.com.devcave.hexagonal.mybank.common.Customer

interface GetCustomerPort {
    fun getCustomer(customerId: Long): Customer?
}