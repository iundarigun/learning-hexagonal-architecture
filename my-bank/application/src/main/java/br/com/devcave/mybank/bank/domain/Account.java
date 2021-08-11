package br.com.devcave.mybank.bank.domain;


import br.com.devcave.mybank.exception.InsufficientFundsException;
import br.com.devcave.mybank.exception.OperationNotAllowedException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Account {
    private final Long id;
    private final Long bankId;
    private final Long ownerId;
    private Double money;

    public static Account newAccount(final Long bankId, final Long ownerId) {
        return new Account(null, bankId, ownerId, 0.0);
    }

    public static Account of(final Long id, final Long bankId, final Long ownerId, final Double money) {
        return new Account(id, bankId, ownerId, money);
    }

    public void withdraw(final Double amount) {
        if (amount.compareTo(0.0) < 0) {
            throw new OperationNotAllowedException();
        }
        if (amount.compareTo(money) < 0) {
            throw new InsufficientFundsException();
        }
        money -= amount;
    }

    public void deposit(final Double amount) {
        if (amount.compareTo(0.0) < 0) {
            throw new OperationNotAllowedException();
        }
        money += amount;
    }
}
