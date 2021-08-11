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
public class WithdrawFromAccountCommand {
    private final static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @NotNull
    private final Long accountId;

    @NotNull
    @Positive
    private final Double amount;

    public static WithdrawFromAccountCommand of(final Long accountId, final Double amount) {
        final WithdrawFromAccountCommand command = new WithdrawFromAccountCommand(accountId, amount);

        final Set<ConstraintViolation<WithdrawFromAccountCommand>> validate = validator.validate(command);

        if (!validate.isEmpty()) {
            throw new InputValidationException(validate);
        }

        return command;
    }

}
