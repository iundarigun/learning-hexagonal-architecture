package br.com.devcave.mybank.bank.port.in;

import br.com.devcave.mybank.customer.port.in.CreateCustomerCommand;
import br.com.devcave.mybank.exception.InputValidationException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateBankCommand {
    private final static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @NotBlank
    @Size(min = 3, max = 255)
    private final String name;

    @NotBlank
    @Size(min = 8, max = 255)
    private final String iban;

    public static CreateBankCommand of(final String name, final String iban){
        final CreateBankCommand command = new CreateBankCommand(name, iban);

        final Set<ConstraintViolation<CreateBankCommand>> validate = validator.validate(command);

        if (!validate.isEmpty()) {
            throw new InputValidationException(validate);
        }

        return command;
    }

}
