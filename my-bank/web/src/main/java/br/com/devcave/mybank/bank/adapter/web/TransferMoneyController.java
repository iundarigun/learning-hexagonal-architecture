package br.com.devcave.mybank.bank.adapter.web;

import br.com.devcave.mybank.bank.port.in.TransferMoneyCommand;
import br.com.devcave.mybank.bank.port.in.TransferMoneyUseCase;
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
@RequestMapping("accounts/transfermoney")
@RequiredArgsConstructor
public class TransferMoneyController {
    private final TransferMoneyUseCase transferMoneyUseCase;

    @PostMapping
    public String transferMoney(@RequestBody final TransferMoneyRequest request) {
        log.info("transferMoney, request={}", request);

        final TransferMoneyCommand command = TransferMoneyCommand.of(
                request.getAccountOriginId(),
                request.getAccountDestinationId(),
                request.getAmount());

        return transferMoneyUseCase.transferMoney(command);
    }
}
