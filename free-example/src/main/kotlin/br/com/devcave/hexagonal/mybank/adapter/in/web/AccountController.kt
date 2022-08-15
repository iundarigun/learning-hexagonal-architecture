package br.com.devcave.hexagonal.mybank.adapter.`in`.web

import br.com.devcave.hexagonal.mybank.adapter.`in`.web.request.CreateAccountRequest
import br.com.devcave.hexagonal.mybank.applications.port.`in`.CreateAccountUseCase
import br.com.devcave.hexagonal.mybank.common.Account
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("accounts")
class AccountController(
    private val createAccountUseCase: CreateAccountUseCase
) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @PostMapping
    fun createAccount(@RequestBody request: CreateAccountRequest): Account {
        return createAccountUseCase.createAccount(
            ownerId = request.ownerId,
            bankId = request.bankId
        ).also {
            logger.info("Response $it")
        }
    }
}