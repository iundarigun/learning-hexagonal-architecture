package br.com.devcave.hexagonal.mybank.adapter.`in`.web

import br.com.devcave.hexagonal.mybank.adapter.`in`.web.request.CreateAccountRequest
import br.com.devcave.hexagonal.mybank.applications.port.`in`.CreateAccountUseCase
import br.com.devcave.hexagonal.mybank.common.Account
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("accounts")
class AccountController(
    private val createAccountUseCase: CreateAccountUseCase
) {

    @PostMapping
    fun createAccount(@RequestBody request: CreateAccountRequest): Account {
        return createAccountUseCase.createAccount(
            ownerId = request.ownerId,
            bankId = request.bankId
        )
    }
}