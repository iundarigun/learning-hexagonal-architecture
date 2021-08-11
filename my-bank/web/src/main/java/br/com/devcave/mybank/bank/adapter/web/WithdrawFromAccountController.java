package br.com.devcave.mybank.bank.adapter.web;

import br.com.devcave.mybank.bank.port.in.WithdrawFromAccountCommand;
import br.com.devcave.mybank.bank.port.in.WithdrawFromAccountUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("accounts/withdraw")
@RequiredArgsConstructor
public class WithdrawFromAccountController {
    private final WithdrawFromAccountUseCase withdrawFromAccountUseCase;

    @PostMapping
    public String withdrawFromAccount(@RequestBody final WithdrawFromAccountRequest request) {
        log.info("depositOnAccount, request={}", request);

        final WithdrawFromAccountCommand command = WithdrawFromAccountCommand.of(request.getAccountId(), request.getAmount());

        return withdrawFromAccountUseCase.withdrawFromAccount(command);
    }
}
