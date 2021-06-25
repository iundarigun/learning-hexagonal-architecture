package br.com.devcave.hexagonal.mybank.adapter.out.persistence

import br.com.devcave.hexagonal.mybank.adapter.out.persistence.entity.CustomerEntity
import br.com.devcave.hexagonal.mybank.adapter.out.persistence.repository.CustomerRepository
import br.com.devcave.hexagonal.mybank.applications.port.out.GetCustomerPort
import br.com.devcave.hexagonal.mybank.common.Customer
import org.springframework.stereotype.Repository

@Repository
class CustomerPersistence(private val customerRepository: CustomerRepository) : GetCustomerPort {

    override fun getCustomer(customerId: Long): Customer? {
        return customerRepository.findById(customerId)
            .orElse(null)?.toCustomer()
    }
}

fun CustomerEntity.toCustomer() =
    Customer(
        this.id,
        this.name,
        this.nationalIdentifier
    )
