package br.com.devcave.mybank.bank.adapter.web;

import br.com.devcave.mybank.bank.port.in.CreateBankCommand;
import br.com.devcave.mybank.bank.port.in.CreateBankUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("banks")
@RequiredArgsConstructor
public class CreateBankController {
    private final CreateBankUseCase createBankUseCase;

    @PostMapping
    public Long createBank(@RequestBody final CreateBankRequest request) {
        log.info("createBank, request={}", request);

        final CreateBankCommand command = CreateBankCommand.of(request.getName(), request.getIban());

        return createBankUseCase.createBank(command);
    }

}
