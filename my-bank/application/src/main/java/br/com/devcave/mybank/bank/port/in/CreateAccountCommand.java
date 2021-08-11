package br.com.devcave.mybank.bank.port.in;

import br.com.devcave.mybank.exception.InputValidationException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateAccountCommand {
    private final static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @NotNull
    private final Long bankId;

    @NotNull
    private final Long ownerId;

    public static CreateAccountCommand of(final Long bankId, final Long ownerId){
        final CreateAccountCommand command = new CreateAccountCommand(bankId, ownerId);

        final Set<ConstraintViolation<CreateAccountCommand>> validate = validator.validate(command);

        if (!validate.isEmpty()) {
            throw new InputValidationException(validate);
        }

        return command;
    }

}
