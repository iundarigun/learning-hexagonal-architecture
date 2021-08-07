package br.com.devcave.mybank.customer.port.in;

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
public class CreateCustomerCommand {

    private final static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @NotBlank
    @Size(min = 3, max = 255)
    private final String name;

    @NotBlank
    @Size(min = 3, max = 20)
    private final String document;

    public static CreateCustomerCommand of(final String name, final String document){
        final CreateCustomerCommand command = new CreateCustomerCommand(name, document);

        final Set<ConstraintViolation<CreateCustomerCommand>> validate = validator.validate(command);

        if (!validate.isEmpty()) {
            throw new InputValidationException(validate);
        }

        return command;
    }
}
