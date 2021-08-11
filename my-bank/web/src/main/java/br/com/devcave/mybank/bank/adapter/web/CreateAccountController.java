package br.com.devcave.mybank.bank.adapter.web;

import br.com.devcave.mybank.bank.port.in.CreateAccountCommand;
import br.com.devcave.mybank.bank.port.in.CreateAccountUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("accounts")
@RequiredArgsConstructor
public class CreateAccountController {
    private final CreateAccountUseCase createAccountUseCase;

    @PostMapping
    public Long createAccount(@RequestBody final CreateAccountRequest request) {
        log.info("createAccount, request={}", request);

        final CreateAccountCommand command = CreateAccountCommand.of(request.getBankId(), request.getOwnerId());

        return createAccountUseCase.createAccount(command);
    }
}
