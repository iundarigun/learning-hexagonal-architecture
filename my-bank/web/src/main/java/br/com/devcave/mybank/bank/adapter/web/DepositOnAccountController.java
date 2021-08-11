package br.com.devcave.mybank.bank.adapter.web;

import br.com.devcave.mybank.bank.port.in.DepositOnAccountCommand;
import br.com.devcave.mybank.bank.port.in.DepositOnAccountUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("accounts/deposit")
@RequiredArgsConstructor
public class DepositOnAccountController {
    private final DepositOnAccountUseCase depositOnAccountUseCase;

    @PostMapping
    public String depositOnAccount(@RequestBody final DepositOnAccountRequest request) {
        log.info("depositOnAccount, request={}", request);

        final DepositOnAccountCommand command = DepositOnAccountCommand.of(request.getAccountId(), request.getAmount());

        return depositOnAccountUseCase.depositOnAccount(command);
    }
}
