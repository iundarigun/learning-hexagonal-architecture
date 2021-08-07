package br.com.devcave.mybank.customer.adapter.web;

import br.com.devcave.mybank.customer.port.in.CreateCustomerCommand;
import br.com.devcave.mybank.customer.port.in.CreateCustomerUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("customers")
@RequiredArgsConstructor
public class CreateCustomerController {

    private final CreateCustomerUseCase createCustomerUseCase;

    @PostMapping
    public Long createCustomer(@RequestBody final CreateCustomerRequest request) {
        log.info("createCustomer, request={}", request);

        final CreateCustomerCommand command = CreateCustomerCommand.of(request.getName(), request.getDocument());

        return createCustomerUseCase.createCustomer(command);
    }
}
