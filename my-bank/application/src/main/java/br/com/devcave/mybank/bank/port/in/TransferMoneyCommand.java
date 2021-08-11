package br.com.devcave.mybank.bank.port.in;

import br.com.devcave.mybank.exception.InputValidationException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Set;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class TransferMoneyCommand {
    private final static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @NotNull
    private final Long accountOriginId;

    @NotNull
    private final Long accountDestinationId;

    @NotNull
    @Positive
    private final Double amount;

    public static TransferMoneyCommand of(final Long accountOriginId, final Long accountDestinationId, final Double amount) {
        final TransferMoneyCommand command = new TransferMoneyCommand(accountOriginId, accountDestinationId, amount);

        final Set<ConstraintViolation<TransferMoneyCommand>> validate = validator.validate(command);

        if (!validate.isEmpty()) {
            throw new InputValidationException(validate);
        }

        return command;
    }

}
